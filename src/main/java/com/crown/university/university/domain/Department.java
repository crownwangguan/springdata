package com.crown.university.university.domain;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity("departments")
@Indexes({
        @Index(fields = {@Field("name")})
})
public class Department {
    @Id
    private ObjectId id;

    private String name;

    @Reference
    private Staff chair;

    public Department(String name, Staff chair) {
        this.name = name;
        this.chair = chair;
    }

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chair=" + chair +
                '}';
    }
}