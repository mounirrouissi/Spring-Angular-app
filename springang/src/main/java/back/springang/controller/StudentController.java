package back.springang.controller;

import back.springang.models.Course;
import back.springang.models.Student;
import back.springang.models.StudentDto;
import back.springang.repository.courseRepo;
import back.springang.repository.studentRepo;

import back.springang.services.studentService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.common.util.impl.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class StudentController {

    private studentRepo studentRepository;

    private courseRepo courseRepository;
    private studentService studentService;

    @Autowired
    public StudentController(studentRepo studentRepository, courseRepo courseRepository, back.springang.services.studentService studentService) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Student> createStudent( @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(student));
    }

  /*  @PostMapping("/course")
    public void createStudent(@Validated @RequestBody Course course)
    {
        return courseRepository.save(course);
    }*/

    @GetMapping("/students")
    public List<Student> allStudents() {
        List<Student> ls = studentRepository.findAll();
        return ls;
    }

    @GetMapping("/courses")
    public List<Course> allCourses() {
        List<Course> ls = courseRepository.findAll();
        return ls;
    }

    @GetMapping("/students/{id}")
    public Optional<Student> student(@PathVariable("id") Long id) {
        return studentRepository.findById(id);
    }


    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable("id") Long Id) {
        Student student = studentRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + Id));
        studentRepository.delete(student);


    }
}



