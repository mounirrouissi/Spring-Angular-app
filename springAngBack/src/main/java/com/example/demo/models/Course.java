package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Course {
    @Id
    @GeneratedValue
    private Long courseId;
    @ManyToOne
    private Student student;

    @Column
    private String courseName;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;


    public Course(Long id, String courseName, Difficulty difficulty) {
    }
}
