package com.crown.university.university.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("staffs")
public class Staff {

    @Id
    private ObjectId id;

    private Person member;

    public Staff() {
    }

    public Staff(ObjectId id, Person member) {
        this.id = id;
        this.member = member;
    }

    public Staff(Person member) {
        this.member = member;
    }

    public ObjectId getId() {
        return id;
    }

    public Person getMember() {
        return member;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", member=" + member +
                '}';
    }
}
