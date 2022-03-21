package com.courseproject.microservice.controller;

import com.courseproject.microservice.model.Attribute;
import com.courseproject.microservice.service.AttributeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController{
    AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        super();
        this.attributeService = attributeService;
    }
    @PostMapping
    Attribute saveAttribute(@RequestBody Attribute attribute){
        return attributeService.saveAttribute(attribute);
    }
    @GetMapping("{id}")
    Attribute getAttribute(@PathVariable("id") Long id){
        Optional<Attribute> opt=attributeService.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    @GetMapping
    List<Attribute> attributeList(){
        return attributeService.getAllAttributes();
    }
}
