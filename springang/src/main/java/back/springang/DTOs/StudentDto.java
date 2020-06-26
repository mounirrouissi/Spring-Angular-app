package back.springang.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class StudentDto {
    private Long id;

    private String first_Name;

    private String last_Name;
}
