package com.amit.spring_database.domain;

import java.util.List;

import com.amit.spring_database.Repository.StudentRepository;
import com.amit.spring_database.iinterface.StudentInterface;
import com.amit.spring_database.model.Class;
import com.amit.spring_database.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDomain implements StudentInterface {
    @Autowired
    StudentRepository repository;

    private static int IDD = 0;

    private synchronized int getIDD() {
        IDD++;
        return IDD;
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(String name, String code, Class aClass) {
        Student newStu = new Student();
        newStu.setId(this.getIDD());
        newStu.setStucCode(code);
        newStu.setAClass(aClass);
        repository.save(newStu);
    }

    @Override
    public Student findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Student findById(Integer id) {
        return repository.findByIdStu(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Integer id, String name, String code, Class aClass) {
        Student c = findById(id);
        if (c != null) {
            c.setName(name);
            c.setStucCode(code);
            c.setAClass(aClass);
            repository.save(c);
        }
    }
}
