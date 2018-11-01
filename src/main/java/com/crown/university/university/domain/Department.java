package com.crown.university.university.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Department")
public class Department {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @OneToOne
    private Staff chair;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public Department(String name, Staff chair) {
        this.name = name;
        this.chair = chair;
    }

    protected Department() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChair(Staff chair) {
        this.chair = chair;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Department{" +
                "chair=" + chair +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
