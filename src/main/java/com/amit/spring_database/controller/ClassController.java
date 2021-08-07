package com.amit.spring_database.controller;

import java.util.List;

import com.amit.spring_database.model.Class;
import com.amit.spring_database.model.request.AddClassRequest;
import com.amit.spring_database.model.response.BaseResponse;
import com.amit.spring_database.model.utils.ApiException;
import com.amit.spring_database.service.ClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @GetMapping("/get-all")
    public BaseResponse<List<Class>> getAll() throws ApiException {
        return classService.getAll();
    }

    @PostMapping("/create")
    public BaseResponse<String> create(@RequestBody AddClassRequest request) throws ApiException {
        return classService.create(request);
    }

    @GetMapping("/find-by-name/{name}")
    public BaseResponse<Class> findByName(@PathVariable String name) throws ApiException {
        return classService.findByName(name);
    }

    @GetMapping("/find-by-id/{id}")
    public BaseResponse<Class> findById(@PathVariable Integer id) throws ApiException {
        return classService.findById(id);
    }

    @PostMapping("/delete/{id}")
    public BaseResponse<String> delete(@PathVariable Integer id) throws ApiException {
        return classService.delete(id);
    }

    @PutMapping("/update/{id}")
    public BaseResponse<String> update(@PathVariable Integer id, @RequestBody AddClassRequest request)
            throws ApiException {
        return classService.update(id, request);
    }
}
