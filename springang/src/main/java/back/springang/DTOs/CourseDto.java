package back.springang.DTOs;

import back.springang.models.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.PackagePrivate;

import javax.persistence.Id;

@Setter

@Getter
public class CourseDto {
   Long id;
    String courseName;
    Long student_id;
    Difficulty difficulty;
}
