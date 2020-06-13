package  back.springang.controller;

import back.springang.models.Course;
import back.springang.models.Student;
import back.springang.repository.studentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor

public class appController {
@Autowired
private studentRepo studentRepository;
    private final com.springangular.repository.courseRepo courseRepository;
    @PostMapping("/addstudent")
    public ResponseEntity<Student> createStudent(@Validated @RequestBody Student student)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(student));
    }

    @PostMapping("/course")
    public Course createStudent(@Validated @RequestBody Course course)
    {
        return courseRepository.save(course);
    }
    
}
