package com.university;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.student.Student;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String name;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Student> student = new ArrayList<>();

    public University() {
    }

    public University(String name, List<Student> student) {
        this.name = name;
        this.student = student;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudent() {
        return this.student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

}
