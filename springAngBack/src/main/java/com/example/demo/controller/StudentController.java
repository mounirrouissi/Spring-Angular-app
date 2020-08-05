package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.CrudDtoServices;
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

    private CrudDtoServices crudDtoServices;
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> allStudents() {
        return studentService.findStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDto findStudentById(@PathVariable Long id) {
        //TODO: mounir complete this
        return null;
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
        // TODO: complete this Mounri please
        return ResponseEntity.accepted().build();
    }

}
