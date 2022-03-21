package com.courseproject.microservice.service;

import com.courseproject.microservice.model.Object;
import com.courseproject.microservice.model.ObjectType;

import java.util.List;

public interface ObjectTypeService {
    ObjectType saveObjectType(ObjectType object);

    List<ObjectType> getAllObjectType();

    ObjectType getObjectType(Long id);
}
