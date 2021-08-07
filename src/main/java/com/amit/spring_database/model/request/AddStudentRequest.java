package com.amit.spring_database.model.request;

import com.amit.spring_database.model.Class;

import lombok.Data;

@Data
public class AddStudentRequest {
    private String name;
    private String code;
    private Class aClass;
}
