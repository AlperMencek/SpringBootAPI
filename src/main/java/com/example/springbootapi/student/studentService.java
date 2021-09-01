package com.example.springbootapi.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        //Optional is an explicit way to show that there may not be a value
        Optional<Student> s = stdRepo.findStudentByEmail(std.getEmail());
        if(s.isPresent()){
            throw new IllegalStateException("Email Already Exists");
        }else{
            stdRepo.save(std);
        }
       System.out.println(std);
    }

    public void deleteStudent(Long id) {

        if(stdRepo.existsById(id)){
            stdRepo.deleteById(id);
        }else{
            throw new IllegalStateException("Student with id:"+id+" does not exist");
        }
    }
}
