package  back.springang.models;

import lombok.*;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;
import org.hibernate.id.UUIDGenerator;


import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Student {

    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column
    private String firstName;
    @Column
    private String lastName;
@ManyToMany(cascade = CascadeType.ALL)
    private Set<Course> courses;

}
