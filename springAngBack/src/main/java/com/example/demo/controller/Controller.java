/*
package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.models.Course;
import com.example.demo.models.Student;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.CrudDtoServices;
import org.springframework.http.ResponseEntity;
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

    
    @PostMapping("/courses/add")
    public void addCourse(@RequestBody CourseDto courseDto)
    {
        Course course=crudDtoServices.DtoToCourse(courseDto);
        courseRepository.save(course);
    }

    @PostMapping("/students/add")
    public void addstudent(@RequestBody Student student)
    {
        studentRepository.save(student);
    }

//display

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

    //Update

    @PutMapping("/students/{id}/update")
    public ResponseEntity<Student> update(@PathVariable("id")Long id, @RequestBody @Validated StudentDto studentDto , BindingResult result)
    {
        if(result.hasErrors()){
            System.out.println("ERROR in Validation");
        }
        Student st=studentRepository.findById(id).get();
        Student updatedStudent=crudDtoServices.updateStudent(st,studentDto);
        studentRepository.save(updatedStudent);
        return ResponseEntity.ok(updatedStudent);

    }

    @PutMapping("/courses/{id}/update")
    public ResponseEntity<Course> update(@PathVariable("id")Long id, @RequestBody  CourseDto CourseDto)
    {
        Course course=courseRepository.findById(id).get();
        Course updatedCourse=crudDtoServices.updateCourse(course,CourseDto);
        courseRepository.save(updatedCourse);
        return ResponseEntity.ok(updatedCourse);
    }

    //Display 1

    @GetMapping("/courses/{id}")
    public CourseDto detailCourse(@PathVariable("id")Long id)
    {
        Course course=courseRepository.findById(id).get();

        return crudDtoServices.CourseToDto(course);
    }
    @GetMapping("/students/{id}")
    public StudentDto detailStudent(@PathVariable("id")Long id)
    {
        Student student=studentRepository.findById(id).get();

        return crudDtoServices.studentToDto(student);
    }

    //Delete

    @DeleteMapping("/students/{id}/delete")
    public void deleteStudent(@PathVariable("id")Long id)
    {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id unfound :" + id));
        
         studentRepository.delete(student);
    }
    @DeleteMapping("/courses/{id}/delete")
    public void deleteCourse(@PathVariable("id")Long id)
    {
        Course c = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id unfound :" + id));
        courseRepository.delete(c);
    }  
}
*/
