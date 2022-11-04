package com.example.studentdata.service;

import com.example.studentdata.model.Student;
import com.example.studentdata.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public void save(Student student){
        studentRepo.save(student);

    }
    public void deleteByStudentId(Long studentId) {
        studentRepo.deleteById(studentId);
    }

    public List<Student> listAll(){
        List<Student> allStudents= studentRepo.findAll();
        return allStudents;
    }
    public Student getByStudentId(Long studentId) {
       Student student = studentRepo.findById(studentId).orElse(new Student());
       return student;
    }
}

