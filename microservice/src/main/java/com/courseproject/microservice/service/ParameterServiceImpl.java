package com.courseproject.microservice.service;

import com.courseproject.microservice.model.ObjectType;
import com.courseproject.microservice.model.Parameter;
import com.courseproject.microservice.repository.ObjectTypeRepository;
import com.courseproject.microservice.repository.ParameterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParameterServiceImpl implements ParameterService{

    ParameterRepository parameterRepository;

    ParameterServiceImpl(ParameterRepository parameterRepository){
        super();
        this.parameterRepository=parameterRepository;
    }

    @Override
    public Parameter saveParameter(Parameter parameter) {
        return parameterRepository.save(parameter);
    }

    @Override
    public List<Parameter> getAllParameters() {
        return parameterRepository.findAll();
    }

    @Override
    public Optional<Parameter> findById(Long id) {
        return parameterRepository.findById(id);
    }
}
