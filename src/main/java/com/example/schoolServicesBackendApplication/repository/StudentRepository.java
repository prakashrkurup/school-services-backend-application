package com.example.schoolServicesBackendApplication.repository;

import com.example.schoolServicesBackendApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
//    Student findByName(String name);
}
