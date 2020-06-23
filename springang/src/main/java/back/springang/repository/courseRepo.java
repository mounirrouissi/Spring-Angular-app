package back.springang.repository;

import back.springang.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepo extends JpaRepository<Course,Long> {

        }