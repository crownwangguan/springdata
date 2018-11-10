package com.crown.university.university.repo.impl;

import com.crown.university.university.domain.Staff;
import com.crown.university.university.repo.StaffRepository;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRepositoryImpl extends BaseRepository<Staff, ObjectId> implements StaffRepository {

    @Autowired
    private Datastore datastore;

    public StaffRepositoryImpl() {
        super(Staff.class);
    }

    public List<Staff> findAll() {
        Query<Staff> rq = datastore.createQuery(Staff.class).disableValidation();
        return rq.asList();
    }
}
