package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/***
 * This class should only handle the CRUD for Student
 */

@RestController
@CrossOrigin
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> allStudents() {
        return studentService.findStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDto findStudentById(@PathVariable Long id) {
        Student student= studentService.findById(id);
        return studentService.toDto(student);
    }

    @PostMapping("/students")
    public StudentDto create(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @PutMapping("/students/{id}/update")
    public StudentDto update(@PathVariable("id")Long id, @RequestBody @Validated StudentDto studentDto , BindingResult result)
    {
        if(result.hasErrors()){
            System.out.println("ERROR in Validation");
            throw new RuntimeException("BAD REQUEST. PLEASE CHECK YOUR OBJECT");
        }
        return studentService.updateStudent(id, studentDto);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        Student student=studentRepository.findById(id).get();
        studentService.delete(student);
        return ResponseEntity.accepted().build();
    }

}