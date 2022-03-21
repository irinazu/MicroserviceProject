package com.courseproject.microservice.controller;

import com.courseproject.microservice.model.Attribute;
import com.courseproject.microservice.model.Parameter;
import com.courseproject.microservice.service.AttributeService;
import com.courseproject.microservice.service.ParameterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController {
    ParameterService parameterService;

    public ParameterController(ParameterService parameterService) {
        super();
        this.parameterService = parameterService;
    }
    @PostMapping
    Parameter saveParameter(@RequestBody Parameter parameter){
        return parameterService.saveParameter(parameter);
    }
    @GetMapping("{id}")
    Parameter getParameter(@PathVariable("id") Long id){
        Optional<Parameter> opt=parameterService.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    @GetMapping
    List<Parameter> parameterList(){
        return parameterService.getAllParameters();
    }
}
