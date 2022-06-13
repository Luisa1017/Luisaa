package com.example.demo.services;

import com.example.demo.models.StudentModel;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public ArrayList<StudentModel> setStudents() {
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    public StudentModel saveStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    public Optional<StudentModel> obtenerPorId(Long id) {
        return studentRepository.findById(id);
    }

    public ArrayList<StudentModel> obtenerPorNombre(String nombre) {
        return StudentRepository.findByNombre(nombre);
    }

    public boolean eliminarEstudiante(Long id) {
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
