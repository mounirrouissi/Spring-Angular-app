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
        student.setFirst_Name(studentDto.getFirst_Name());
        student.setFirst_Name(studentDto.getFirst_Name());
        return student;
    }
}
