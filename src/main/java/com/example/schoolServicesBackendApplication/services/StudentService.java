package com.example.schoolServicesBackendApplication.services;

import com.example.schoolServicesBackendApplication.entity.Student;
import com.example.schoolServicesBackendApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

//    public Student getStudentByName(String name) {
//        return repository.findByName(name);
//    }

    public String deleteStudent(int id) {
         repository.deleteById(id);
         return "Student deleted" +id;
    }

    public Student updateStudent(Student student) {
        Student existingStudent = repository.findById(student.getStudent_id()).orElse(null);
        existingStudent.setStudent_id(student.getStudent_id());
        existingStudent.setStudent_email(student.getStudent_email());
        existingStudent.setStudent_name(student.getStudent_name());
        existingStudent.setStudent_department(student.getStudent_department());
        existingStudent.setStudent_image(student.getStudent_image());
        return repository.save(existingStudent);
    }
}
