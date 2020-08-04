package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.models.Course;
import com.example.demo.models.Student;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.CrudDtoServices;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class Controller {
    private CrudDtoServices crudDtoServices;
    private StudentRepository studentRepository;

    public Controller(CrudDtoServices crudDtoServices, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.crudDtoServices = crudDtoServices;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    private CourseRepository courseRepository;


    @GetMapping("/students")
    public List<StudentDto> allStudents() {
        List<Student> listS = studentRepository.findAll();
        List<StudentDto> listDto = new ArrayList<>();
        for (Student s : listS) {
            listDto.add(crudDtoServices.studentToDto(s));
        }
        return listDto;
    }


    @GetMapping("/courses")
    public List<CourseDto> allCourses() {
        List<Course> listS = courseRepository.findAll();
        List<CourseDto> listDto = new ArrayList<>();
        for (Course s : listS) {
            listDto.add(crudDtoServices.CourseToDto(s));
        }
        return listDto;
    }

    @PutMapping("/students/{id}/update")
    public Student update(@PathVariable("id")Long id, @RequestBody @Validated StudentDto studentDto , BindingResult result)
    {
        if(result.hasErrors()){
            System.out.println("ERROR in Validation");
        }
        Student st=studentRepository.findById(id).get();
        Student updatedStudent=crudDtoServices.updateStudent(st,studentDto);
        return updatedStudent;

    }

    @PutMapping("/courses/{id}/update")
    public Course update(@PathVariable("id")Long id, @RequestBody @Validated CourseDto CourseDto , BindingResult result)
    {
        if(result.hasErrors()){
            System.out.println("ERROR in Validation");
        }
        Course course=courseRepository.findById(id).get();
        Course updatedCourse=crudDtoServices.updateCourse(course,CourseDto);
        return updatedCourse;
    }
    @GetMapping("/courses/{id}")
    public Course detailCourse(@PathVariable("id")Long id)
    {
        Course course=courseRepository.findById(id).get();
        return course;
    }
}
