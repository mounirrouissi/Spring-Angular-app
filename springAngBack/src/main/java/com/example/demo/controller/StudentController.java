package com.example.demo.controller;

import com.example.demo.dto.JwtSignInResponse;
import com.example.demo.dto.SignInDtoRequest;
import com.example.demo.dto.StudentDto;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/***
 * This class should only handle the CRUD for Student
 */

@RestController
public class StudentController {

    private StudentRepository studentRepository;
    @Autowired
    private SecurityService securityService;
@Autowired
private AuthenticationManager authenticationManager;
    @Autowired
    private StudentService studentService;

@Autowired
private JwtUtil jwtUtil;
    @PostMapping("/signIn")
    public ResponseEntity sign(@RequestBody SignInDtoRequest signInDtoRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDtoRequest.getFirstName()
                                                                                        , signInDtoRequest.getPassword()));
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        final UserDetails userDetails=securityService.loadUserByUsername(signInDtoRequest.getFirstName());

        String jwt=jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtSignInResponse(jwt));
    }


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