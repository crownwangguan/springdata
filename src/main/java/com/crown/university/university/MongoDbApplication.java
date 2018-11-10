package com.crown.university.university;

import com.crown.university.university.domain.*;
import com.crown.university.university.repo.DepartmentRepository;
import com.crown.university.university.repo.StaffRepository;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Class for the University Application.
 * On Startup Initialize Database with Staff and Departments.
 */
@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Staff
        Staff deanJones = new Staff(new Person("John", "Jones"));
        staffRepository.create(deanJones);
        Staff profMiller = new Staff(new Person("Judy", "Miller"));
        staffRepository.create(profMiller);
        Staff profDavis = new Staff(new Person("James", "Davis"));
        staffRepository.create(profDavis);

        //Departments
        Department humanities = new Department("Humanities", deanJones);
        Department naturalSciences = new Department("Natural Sciences", deanJones);
        Department socialSciences = new Department("Social Sciences", deanJones);
        departmentRepository.create(humanities);
        departmentRepository.create(naturalSciences);
        departmentRepository.create(socialSciences);

        staffRepository.findAll().forEach(
                staff -> System.out.println(staff)
        );

        Department naturalSciences1 = departmentRepository.read(new ObjectId("5be75e4596b0554f10e25e4f"));
        System.out.println(naturalSciences1);

        UpdateOperations<Department> ops = departmentRepository.createOperations()
                .set("chair", new Staff(new Person("Guan", "Wang")));
        departmentRepository.update(naturalSciences1, ops);
    }
}
