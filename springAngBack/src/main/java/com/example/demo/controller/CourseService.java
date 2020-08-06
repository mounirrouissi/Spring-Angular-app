package com.example.demo.controller;
import com.example.demo.models.Course;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.models.Student;
import com.example.demo.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseService {

    private CourseRepository CourseRepository;
    private CourseMapper CourseMapper;

    /**
     * we call this dependency injection by constructor.
     * there is another way without constructor like so :
     *
     * @Autorire private CourseRepository CourseRepository;
     */
    public CourseService(CourseRepository CourseRepository, CourseMapper CourseMapper) {
        this.CourseRepository = CourseRepository;
        this.CourseMapper = CourseMapper;
    }

    public List<CourseDto> findCourses() {
        List<Course> Courses = CourseRepository.findAll();
        List<CourseDto> CourseDtoList = new ArrayList<>();
        for (Course Course : Courses) {
            CourseDtoList.add(CourseMapper.toCourseDTO(Course));
        }
        return CourseDtoList;
        /***
         * or we can just write in lambda expression like
         *
         *  return CourseRepository.findAll()
         *                          .stream()
         *                          .map(Course -> CourseMapper.toCourseDTO(Course))
         *                          .collect(Collectors.toList());
         *
         *
         */
    }

    public CourseDto createCourse(CourseDto CourseDto) {
        Course CourseForSave = new Course();
        CourseForSave = CourseMapper.toCourse(CourseForSave, CourseDto);
        CourseRepository.save(CourseForSave);
        /**
         * we call the mapper again to create another CourseDTO to map the id that has been created in the database
         */
        return CourseMapper.toCourseDTO(CourseForSave);
    }

    public Course findById(Long id) {
        Course Course = CourseRepository.findById(id).get();
        return Course;
    }

    public CourseDto updateCourse(Long id, CourseDto CourseDto) {
        Course st = CourseRepository.findById(id).get();
        Course updatedCourse = CourseMapper.toCourse(st, CourseDto);
        CourseRepository.save(updatedCourse);
        return CourseDto;
    }

    public void delete(Course Course)
    {
        CourseRepository.deleteById(Course.getCourseId());
    }

    public CourseDto toDto(Course Course)
    {
        return CourseMapper.toCourseDTO(Course);
    }
}
