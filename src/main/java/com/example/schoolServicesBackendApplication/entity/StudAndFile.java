package com.example.schoolServicesBackendApplication.entity;
import org.springframework.web.multipart.MultipartFile;


public class StudAndFile {
    private int student_id;
    private String student_name;
    private String student_email;
    private String student_department;
    private String student_image;
    private MultipartFile student_img;
}
