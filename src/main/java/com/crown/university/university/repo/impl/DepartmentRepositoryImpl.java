package com.crown.university.university.repo.impl;

import com.crown.university.university.domain.Department;
import com.crown.university.university.repo.DepartmentRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepositoryImpl extends BaseRepository<Department, ObjectId> implements DepartmentRepository {
    public DepartmentRepositoryImpl() {
        super(Department.class);
    }
}
