package com.courseproject.microservice.controller;

import com.courseproject.microservice.model.Object;
import com.courseproject.microservice.model.ObjectType;
import com.courseproject.microservice.service.ObjectServiceImpl;
import com.courseproject.microservice.service.ObjectTypeService;
import com.courseproject.microservice.service.ObjectTypeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class ObjectTypeController {
    ObjectTypeService objectTypeService;

    ObjectTypeController(ObjectTypeService objectTypeService){
        super();
        this.objectTypeService=objectTypeService;
    }
    //Проблема в касте числа к объекту (в postamn нужен обхект в объекте)
    @PostMapping
    ObjectType saveObject(@RequestBody ObjectType object){

        return objectTypeService.saveObjectType(object);
    }
    @GetMapping
    List<ObjectType> getAllObject(){

        return objectTypeService.getAllObjectType();
    }

    @GetMapping("{id}")
    ObjectType getObjectById(@PathVariable("id") Long id){
        return objectTypeService.getObjectType(id);
    }
}
