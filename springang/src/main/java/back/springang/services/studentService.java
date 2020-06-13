package  back.springang.services;

import back.springang.models.Student;
import back.springang.repository.studentRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class studentService {

  private final back.springang.repository.studentRepo studentRepo;
    public Student save(Student student)
    {
        Student saved=studentRepo.save(buildStudent(student));
        student.setId(saved.getId());
        return saved;


    }

    private Student buildStudent(Student student) {
        return Student.builder().firstName(student.getFirstName())
                .lastName(student.getLastName()).courses(student.getCourses()).build();
    }

}
