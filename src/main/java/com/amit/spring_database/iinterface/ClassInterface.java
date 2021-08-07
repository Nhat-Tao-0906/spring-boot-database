package com.amit.spring_database.iinterface;

import java.util.List;

import com.amit.spring_database.model.Class;

public interface ClassInterface {
    public List<Class> getAll();

    public void create(String name);

    public Class findByName(String name);

    public Class findById(Integer id);

    public void delete(Integer id);

    public void update(Integer id, String name);
}
