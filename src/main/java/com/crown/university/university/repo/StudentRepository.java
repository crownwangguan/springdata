package com.crown.university.university.repo;

import com.crown.university.university.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer>  {
}
