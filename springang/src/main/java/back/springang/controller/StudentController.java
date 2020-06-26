package back.springang.controller;
import back.springang.DTOs.Mapper;

import back.springang.DTOs.StudentDto;
import back.springang.models.Course;
import back.springang.models.Student;
import back.springang.repository.courseRepo;
import back.springang.repository.studentRepo;

import back.springang.services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class StudentController {

private Mapper mapper;
    private studentRepo studentRepository;

    private courseRepo courseRepository;
    private studentService studentService;

    @Autowired
    public StudentController(Mapper mapper, studentRepo studentRepository, courseRepo courseRepository,
                             back.springang.services.studentService studentService) {
        this.mapper = mapper;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    @PostMapping("/registrationStudent")
    public Student createStudent(@RequestBody StudentDto studentDto, BindingResult bindingResult) {

        Student st=this.mapper.convertToStudentEntity(studentDto);

        return studentRepository.save(st);
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



