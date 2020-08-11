package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
//import org.springframework.security.crypto.password.PasswordEncoder;

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
    private String firstName;
    @Column
    private String lastName;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Course> courses;
private String password;
    public Student(Long id, String fist, String last) {
        this.id = id;
        this.firstName = fist;
        this.lastName = last;
    }
}
