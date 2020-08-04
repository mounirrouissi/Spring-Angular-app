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
    public StudentDto studentToDto(Student s)
    {
        StudentDto studentDto=modelMapper.map(s,StudentDto.class);
        return studentDto;
    }
    public CourseDto CourseToDto(Course s)
    {
        CourseDto CourseDto=modelMapper.map(s,CourseDto.class);
        return CourseDto;
    }
//update

    public Student updateStudent(Student student,StudentDto studentDto){
        student.setFirst_Name(studentDto.getFirst_Name());
        student.setFirst_Name(studentDto.getFirst_Name());
        return student;
    }

    public Course updateCourse(Course course,CourseDto courseDto){
        course.setCourseName(courseDto.getCourseName());
        course.setDifficulty(courseDto.getDifficulty());
        return course;
    }
/*    public Course convertToCourseEntity(CourseDto courseDto) {
        //Student st = this.studentRepository.findById(courseDto.getStudent_id()).get();
        Course entity = new Course(courseDto.getId(), courseDto.getCourseName(), courseDto.getDifficulty());

        return entity;

    }*/


}
