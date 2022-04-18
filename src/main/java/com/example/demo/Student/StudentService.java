package com.example.demo.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 3. Autowired Service
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    // https://stackoverflow.com/questions/71907612/how-to-understand-transactional-with-setters-in-java#71909451
    public Student getAndUpdateStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
        () -> new IllegalStateException("invalid id"));

        // student.setName("asdf;dfjklasdf");
        student.name = "222222222";
        
        return student;
    }
}
