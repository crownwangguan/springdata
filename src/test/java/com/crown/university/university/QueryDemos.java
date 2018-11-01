package com.crown.university.university;

import com.crown.university.university.domain.Person;
import com.crown.university.university.repo.CourseRepository;
import com.crown.university.university.repo.DepartmentRepository;
import com.crown.university.university.repo.StaffRepository;
import com.crown.university.university.repo.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDemos {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DepartmentRepository departmentRepository;



    /**
     * Simple Property Expression Queries.
     *
     * Students persisted to H2 in-Memory database at startup.
     * @see UniversityApplication
     */
    @Test
    public void simpleQueryExamples() {

        System.out.println("\nFind 20 year old students");
        studentRepository.findByAge(20).forEach(System.out::println);
        System.out.println("\nFind full time old students");
        studentRepository.findByFullTime(true).forEach(System.out::println);
        System.out.println("\nFind students with 'doe' as last name");
        studentRepository.findByAttendeeLastName("doe").forEach(System.out::println);
    }

    /**
     * Advanced Property Expression Queries
     *
     * Students persisted to H2 in-Memory database at startup.
     * @see UniversityApplication
     */
    @Test
    public void intermediateQueryExamples() {
        System.out.println("Find students by name and traverse entities \n" +
                studentRepository.findByAttendeeFirstNameAndAttendeeLastName("jane","doe"));
        System.out.println("Find students by name with Person Object \n" +
                studentRepository.findByAttendee(new Person("jane","doe")));

        System.out.println("\nFind Students older than 19");
        studentRepository.findByAgeGreaterThan(19).forEach(System.out::println);

        System.out.println("\nFind Students under 19");
        studentRepository.findByAgeLessThan(19).forEach(System.out::println);

        System.out.println("\nFind Students with last name Doe, despite the case");
        studentRepository.findByAttendeeLastNameIgnoreCase("Doe").forEach(System.out::println);

        System.out.println("\nFind Students with an sm in the last name");
        studentRepository.findByAttendeeLastNameLike("sm%").forEach(System.out::println);

        System.out.println("\nFind first Student in alphabet \n" +
                studentRepository.findFirstByOrderByAttendeeLastNameAsc());

        System.out.println("\nFind oldest Student \n" +
                studentRepository.findTopByOrderByAgeDesc());

        System.out.println("\nFind 3 oldest Students \n" +
                studentRepository.findTop3ByOrderByAgeDesc());

    }
}
