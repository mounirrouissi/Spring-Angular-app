package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.models.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public StudentDto toStudentDTO(Student student) {
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    public Student toStudent(Student student, StudentDto studentDto){
        student.setFirstName(studentDto.getFirst_Name());
        student.setLastName(studentDto.getLast_Name());
        return student;
    }
}