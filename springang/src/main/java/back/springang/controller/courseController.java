package back.springang.controller;

import back.springang.DTOs.CourseDto;
import back.springang.DTOs.Mapper;
import back.springang.DTOs.StudentDto;
import back.springang.models.Course;
import back.springang.models.Student;
import back.springang.repository.courseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class courseController {
    private courseRepo courseRepository;
    private Mapper mapper;
@Autowired
    public courseController(courseRepo courseRepository) {
        this.courseRepository = courseRepository;
    }
    @DeleteMapping("/courses/{id}")
    public void delete(@PathVariable("id") Long courseId)
    {
        Course c=courseRepository.findById(courseId).orElseThrow(()-> new IllegalArgumentException("id unfound :"+courseId));
        courseRepository.delete(c);

    }

    @GetMapping("/courses")
    public List<Course> allCourses() {
        List<Course> ls = courseRepository.findAll();
        return ls;
    }

    @PostMapping("/registrationCourse")
    public Course createCourse(@RequestBody CourseDto courseDto) {

        Course c=this.mapper.convertToCourseEntity(courseDto);
     return   courseRepository.save(c);
    }
}
