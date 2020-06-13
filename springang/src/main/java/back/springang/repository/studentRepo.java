package back.springang.repository;

import back.springang.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends CrudRepository<Student,Long> {

}
