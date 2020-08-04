package com.example.demo.dto;

import com.example.demo.models.Difficulty;
import lombok.Data;

@Data
public class CourseDto {
    private Long courseId;
    private String courseName;
    private Difficulty difficulty;
}
