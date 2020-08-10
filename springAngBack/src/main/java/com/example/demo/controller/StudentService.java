package com.example.demo.controller;

import com.example.demo.dto.SignInDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class should hold the business logic.
 * That been said that all the business logic in the StudentController
 * must be on the service layer
 */

@Service
public class StudentService {
private AuthenticationManager authenticationManager;
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;


    public StudentService(AuthenticationManager authenticationManager, StudentRepository studentRepository, StudentMapper studentMapper) {
        this.authenticationManager = authenticationManager;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    /**
     * we call this dependency injection by constructor.
     * there is another way without constructor like so :
     *
     * @Autorire private StudentRepository studentRepository;
     */


    public void login(SignInDto signInDto){
        Authentication auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDto.getFirst_Name(),signInDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public List<StudentDto> findStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student : students) {
            studentDtoList.add(studentMapper.toStudentDTO(student));
        }
        return studentDtoList;
        /***
         * or we can just write in lambda expression like
         *
         *  return studentRepository.findAll()
         *                          .stream()
         *                          .map(student -> studentMapper.toStudentDTO(student))
         *                          .collect(Collectors.toList());
         *
         *
         */
    }

    public StudentDto createStudent(StudentDto studentDto) {
        Student studentForSave = new Student();
        studentForSave = studentMapper.toStudent(studentForSave, studentDto);
        studentRepository.save(studentForSave);
        /**
         * we call the mapper again to create another studentDTO to map the id that has been created in the database
         */
        return studentMapper.toStudentDTO(studentForSave);
    }

    public Student findById(Long id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student st = studentRepository.findById(id).get();
        Student updatedStudent = studentMapper.toStudent(st, studentDto);
        studentRepository.save(updatedStudent);
        return studentDto;
    }

    public void delete(Student student)
    {
        studentRepository.deleteById(student.getId());
    }

public StudentDto toDto(Student student)
{
    return studentMapper.toStudentDTO(student);
}
    /*
        public Student updateStudent(Student student,StudentDto studentDto){
        student.setFirst_Name(studentDto.getFirst_Name());
        student.setFirst_Name(studentDto.getFirst_Name());
        return student;
    }
            Student st=studentRepository.findById(id).get();
        Student updatedStudent=crudDtoServices.updateStudent(st,studentDto);
        return updatedStudent;
     */


}