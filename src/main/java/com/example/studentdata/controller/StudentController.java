package com.example.studentdata.controller;

import com.example.studentdata.model.Student;
import com.example.studentdata.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Void> updated(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deleteByStudentId")
    public ResponseEntity<Void> deleteByStudentId(@RequestParam Long id) {
        studentService.deleteByStudentId(id);
        return new ResponseEntity<>(HttpStatus.GONE);

    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Student>> listAll () {
        List <Student> allStudents = studentService.listAll();
        return ResponseEntity.ok(allStudents);

    }
    @GetMapping("/getByStudentId")
    public ResponseEntity<Student> getByStudentId(@RequestParam("id")Long id) {
            Student student= studentService.getByStudentId(id);
            return ResponseEntity.ok(student);
    }
}
