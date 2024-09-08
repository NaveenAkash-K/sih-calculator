package com.project.sihcalci.service;

import com.project.sihcalci.models.Parameter;
import com.project.sihcalci.repositories.ParameterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ParameterService {
    private final ParameterRepository parameterRepository;

    public List<Parameter> getAParameters() {
        return parameterRepository.findAll();
    }

    public Parameter addParameter(Parameter parameter) {
        return parameterRepository.save(parameter);
    }

    public String deleteParameter(Long id) {
        parameterRepository.deleteById(id);
        return "Parameter Deleted Successfully";
    }
}
