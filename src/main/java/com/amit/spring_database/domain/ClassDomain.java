package com.amit.spring_database.domain;

import java.util.List;

import com.amit.spring_database.Repository.ClassRepository;
import com.amit.spring_database.iinterface.ClassInterface;
import com.amit.spring_database.model.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassDomain implements ClassInterface {
    @Autowired
    ClassRepository repository;

    private static int IDD = 0;

    private synchronized int getIDD() {
        IDD++;
        return IDD;
    }

    @Override
    public List<Class> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(String name) {
        Class newClass = new Class();
        newClass.setId(getIDD());
        newClass.setName(name);
        repository.save(newClass);
    }

    @Override
    public Class findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Class findById(Integer id) {
        return repository.findByIdClass(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Integer id, String name) {
        Class c = findById(id);
        if (c != null) {
            c.setName(name);
            repository.save(c);
        }
    }
}
