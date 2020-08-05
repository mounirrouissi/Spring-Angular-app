package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class should hold the business logic.
 * That been said that all the business logic in the StudentController
 * must be on the service layer
 */

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    /**
     * we call this dependency injection by constructor.
     * there is another way without constructor like so :
     *     @Autorire
     *     private StudentRepository studentRepository;
     *
     */
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> findStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for(Student student: students) {
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

    public Student findById(Long id) {
        // TODO: Mounir finish this please
        return null;
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student st = studentRepository.findById(id).get();
        Student updatedStudent = studentMapper.toStudent(st, studentDto);
        studentRepository.save(updatedStudent);
        return studentDto;
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
