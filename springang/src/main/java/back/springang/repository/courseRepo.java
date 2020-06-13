package com.springangular.repository;

import back.springang.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepo extends CrudRepository<Course,Long> {
}
