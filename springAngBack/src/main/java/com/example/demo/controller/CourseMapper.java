package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.models.Course;
import com.example.demo.models.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public CourseDto toCourseDTO(Course Course) {
        CourseDto CourseDto = modelMapper.map(Course, CourseDto.class);
        return CourseDto;
    }

    public Course toCourse(Course Course, CourseDto CourseDto){
        Course.setCourseName(CourseDto.getCourseName());
        Course.setDifficulty(CourseDto.getDifficulty());
        return Course;
    }
}
