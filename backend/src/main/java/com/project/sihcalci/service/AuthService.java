package com.project.sihcalci.service;

import com.project.sihcalci.models.User;
import com.project.sihcalci.repositories.UserRepository;
import com.project.sihcalci.request.LoginRequest;
import com.project.sihcalci.response.LoginResponse;
import com.project.sihcalci.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody  LoginRequest loginRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        }catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
        User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() ->new RuntimeException("User not Found"));
        String jwtToken = jwtUtil.generateToken(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setSuccess(passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()));
        loginResponse.setJwt(jwtToken);
        return loginResponse;
    }

    @PreAuthorize("hasRole('PARTICIPANT')")
    public String firstQuery(){
        return "firstQuery";
    }

}
