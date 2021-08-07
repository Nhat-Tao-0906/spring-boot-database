package com.amit.spring_database.Repository;

import com.amit.spring_database.model.Class;

import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@EnableJdbcRepositories
public interface ClassRepository extends JpaRepository<Class, Integer> {
    @Query(value = "SELECT * FROM classes WHERE name = :name", nativeQuery = true)
    Class findByName(String name);

    @Query(value = "SELECT * FROM classes WHERE id_class = :id", nativeQuery = true)
    Class findByIdClass(Integer id);
}
