package back.springang.models;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Set;

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

}
