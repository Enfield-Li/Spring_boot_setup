package com.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String indexnumber;

    public Student() {
    }

    public Student(String indexnumber) {
        this.indexnumber = indexnumber;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndexnumber() {
        return this.indexnumber;
    }

    public void setIndexnumber(String indexnumber) {
        this.indexnumber = indexnumber;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", indexnumber='" + getIndexnumber() + "'" +
            "}";
    }
}
