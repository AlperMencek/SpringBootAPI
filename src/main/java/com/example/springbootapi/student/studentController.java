package com.example.springbootapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student/")
public class studentController {
    private final studentService stdService;
    @Autowired
    public studentController(studentService stdService) {
        this.stdService = stdService;
    }

    @GetMapping
    public List<Student> getStudents() {
            return stdService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student std){
        stdService.addNewStudent(std);

    }
}
