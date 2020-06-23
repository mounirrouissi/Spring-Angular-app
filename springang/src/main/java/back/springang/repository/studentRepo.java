package back.springang.repository;

import back.springang.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studentRepo extends JpaRepository<Student, Long> {





}
