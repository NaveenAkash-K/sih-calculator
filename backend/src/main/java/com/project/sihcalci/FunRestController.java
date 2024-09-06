package com.project.sihcalci;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/first")
    public String first() {
        return "Hello World";
    }
}
