package com.example.demo.services;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.models.Course;
import com.example.demo.models.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CrudDtoServices {

    ModelMapper modelMapper = new ModelMapper();

    public CourseDto CourseToDto(Course s)
    {
        CourseDto CourseDto=modelMapper.map(s,CourseDto.class);
        return CourseDto;
    }

    public Course updateCourse(Course course,CourseDto courseDto){
        course.setCourseName(courseDto.getCourseName());
        course.setDifficulty(courseDto.getDifficulty());
        return course;
    }
}
