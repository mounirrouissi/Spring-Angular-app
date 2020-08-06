package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class CourseController {

    private com.example.demo.repositories.CourseRepository CourseRepository;

    @Autowired
    private CourseService CourseService;


    @GetMapping("/Courses")
    public List<CourseDto> allCourses() {
        return CourseService.findCourses();
    }


    @GetMapping("/Courses/{id}")
    public CourseDto findCourseById(@PathVariable Long id) {
        Course Course = CourseService.findById(id);
        return CourseService.toDto(Course);
    }


    @PostMapping("/Courses")
    public CourseDto create(@RequestBody CourseDto CourseDto) {
        return CourseService.createCourse(CourseDto);
    }


    @PutMapping("/Courses/{id}/update")
    public CourseDto update(@PathVariable("id") Long id, @RequestBody @Validated CourseDto CourseDto, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("ERROR in Validation");
            throw new RuntimeException("BAD REQUEST. PLEASE CHECK YOUR OBJECT");
        }
        return CourseService.updateCourse(id, CourseDto);
    }


    @DeleteMapping("/Courses/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        Course Course = CourseRepository.findById(id).get();
        CourseService.delete(Course);
        return ResponseEntity.accepted().build();
    }

}
