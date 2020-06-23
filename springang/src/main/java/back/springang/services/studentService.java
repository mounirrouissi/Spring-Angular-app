package  back.springang.services;

import back.springang.models.Student;
import back.springang.repository.studentRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class studentService {

  private studentRepo studentRepository;
    @Autowired
    public studentService(studentRepo studentRepository) {
        this.studentRepository=studentRepository;
    }


    public Student update(Student st)
    {

        st.setId(5545L);
        st.setFirst_Name("fold");
        st.setLast_Name("ffs");
        return st;
    }

/*
    save student
*/
    public Student save(Student student)
    {
        Student saved=studentRepository.save(buildStudent(student));
        student.setId(saved.getId());
        return saved;


    }

    private Student buildStudent(Student student) {
        return Student.builder().first_Name(student.getFirst_Name())
                .last_Name(student.getLast_Name()).build();
    }


    public Optional<Student> findStudent(Long id) {
        return studentRepository.findById(id);

    }
}
