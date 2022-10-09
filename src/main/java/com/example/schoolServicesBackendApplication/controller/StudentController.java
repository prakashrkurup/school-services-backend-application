package com.example.schoolServicesBackendApplication.controller;

import com.example.schoolServicesBackendApplication.entity.Student;
import com.example.schoolServicesBackendApplication.services.StudentService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api/v1")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addstudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        if(null==student.getStudent_name() || student.getStudent_name().trim().equals("") || null==student.getStudent_email() || student.getStudent_email().equals("") || null==student.getStudent_department() || student.getStudent_department().trim().equals("")){
            System.out.println("Wrong dat====>");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Valid dat====>");
        service.saveStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        return service.getStudents();
    }

    @GetMapping("/studentById/{id}")
    public Student findStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

//    @GetMapping("/student/{name}")
//    public Student findStudentByName(@PathVariable String name) {
//        return service.getStudentByName(name);
//    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if(null==student.getStudent_name() || student.getStudent_name().trim().equals("") || null==student.getStudent_email() || student.getStudent_email().equals("") || null==student.getStudent_department() || student.getStudent_department().trim().equals("")){
            System.out.println("Wrong dat====>");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        service.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }

}
