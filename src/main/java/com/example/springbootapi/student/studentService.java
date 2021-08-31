package com.example.springbootapi.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class studentService {
    private final studentRepository stdRepo;

    public studentService(studentRepository stdRepo) {
        this.stdRepo = stdRepo;
    }

    public List<Student> getStudents() {
      return stdRepo.findAll();
    }

    public void addNewStudent(Student std) {
       System.out.println(std);
    }
}
