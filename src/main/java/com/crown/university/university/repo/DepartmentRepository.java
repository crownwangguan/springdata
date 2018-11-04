package com.crown.university.university.repo;

import com.crown.university.university.domain.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, Integer> {

    Department findByName(String name);

    @Query("{ 'name' : { $regex: ?0 } }")
    List<Department> findNameByPattern(String pattern);

    //This method fails because cannot perform Joins across DBRef's
    List<Department> findByChairMemberLastName(String lastName);

}
