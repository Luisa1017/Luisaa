package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> {
    public static ArrayList<StudentModel> findByNombre(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }
}
