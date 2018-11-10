package com.crown.university.university.repo;

import com.crown.university.university.domain.Department;
import org.bson.types.ObjectId;

public interface DepartmentRepository extends CrudRepository<Department, ObjectId> {
}
