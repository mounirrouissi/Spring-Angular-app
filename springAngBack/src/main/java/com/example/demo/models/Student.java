package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String first_Name;
    @Column
    private String last_Name;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Course> courses;

    public Student(Long id, String fist, String last) {
        this.id = id;
        this.first_Name = fist;
        this.last_Name = last;
    }
}
