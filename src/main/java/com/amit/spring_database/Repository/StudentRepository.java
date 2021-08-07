package com.amit.spring_database.Repository;

import com.amit.spring_database.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM student WHERE name = :name", nativeQuery = true)
    Student findByName(String name);

    @Query(value = "SELECT * FROM student WHERE id_class = :id", nativeQuery = true)
    Student findByIdStu(Integer id);
}
