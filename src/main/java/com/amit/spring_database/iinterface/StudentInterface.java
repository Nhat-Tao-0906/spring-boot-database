package com.amit.spring_database.iinterface;

import java.util.List;

import com.amit.spring_database.model.Class;
import com.amit.spring_database.model.Student;

public interface StudentInterface {
    public List<Student> getAll();

    public void create(String name, String code, Class aClass);

    public Student findByName(String name);

    public Student findById(Integer id);

    public void delete(Integer id);

    public void update(Integer id, String name, String code, Class aClass);
}
