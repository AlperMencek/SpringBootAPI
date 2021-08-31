package com.example.springbootapi.student;


import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String name;
    //Makes age not a column on database, we will calculate from DOB
    @Transient
    private Integer age;
    private LocalDate DOB;
    private String email;

    //Constructors
    public Student(){
    }

    public Student(Long id, String name,  LocalDate DOB, String email) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.email = email;
    }

    public Student(String name, LocalDate DOB, String email){
        this.name = name;
        this.DOB = DOB;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.DOB, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //Return Student as string
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", DOB=" + DOB +
                ", email='" + email + '\'' +
                '}';
    }
}
