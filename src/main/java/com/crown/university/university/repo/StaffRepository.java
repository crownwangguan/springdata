package com.crown.university.university.repo;

import com.crown.university.university.domain.Staff;
import org.bson.types.ObjectId;

import java.util.List;

public interface StaffRepository extends CrudRepository<Staff, ObjectId> {
    List<Staff> findAll();
}
