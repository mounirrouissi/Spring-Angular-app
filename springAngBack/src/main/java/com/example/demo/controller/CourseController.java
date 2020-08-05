package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.models.Course;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.CrudDtoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CrudDtoServices crudDtoServices;
    @Autowired
    private CourseRepository courseRepository;

    //TODO: Refactor this RestController like tthe StudentController. Move the business logic to a CourserService and create a CourseMapper like I
    // did for StudentMapper.

    @GetMapping("/courses")
    public List<CourseDto> allCourses() {
        List<Course> listS = courseRepository.findAll();
        List<CourseDto> listDto = new ArrayList<>();
        for (Course s : listS) {
            listDto.add(crudDtoServices.CourseToDto(s));
        }
        return listDto;
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
