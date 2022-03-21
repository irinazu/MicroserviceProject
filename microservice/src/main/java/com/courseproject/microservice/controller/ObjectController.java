package com.courseproject.microservice.controller;

import com.courseproject.microservice.model.Object;
import com.courseproject.microservice.service.ObjectService;
import com.courseproject.microservice.service.ObjectServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/objects")
public class ObjectController {

    ObjectService objectService;

    ObjectController(ObjectService objectService){
        super();
        this.objectService=objectService;
    }
    //Проблема в касте числа к объекту (в postamn нужен обхект в объекте)
    @PostMapping
    Object saveObject(@RequestBody Object object){

        return objectService.saveObject(object);
    }

    @GetMapping
    List<Object> getAllObject(){
        return objectService.getAllObjects();
    }

    @GetMapping("{id}")
    Object getObjectById(@PathVariable("id") Long id){
        Optional<Object> opt=objectService.getObject(id);
        if(opt.isPresent()){
            Object object=opt.get();
            return object;
        }
        return null;
    }

}
