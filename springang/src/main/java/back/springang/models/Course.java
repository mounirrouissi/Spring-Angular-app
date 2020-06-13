package  back.springang.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> student;
@Column
    private String courseName;
@Enumerated(value = EnumType.STRING)
private Difficulty difficulty;

}
