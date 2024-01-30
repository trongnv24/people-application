package TrainingjavaSpringBoot.people.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Table(name = "people")
@Entity
public class PeopleEntity {

    @Id
    private String id;
    private String lastName;
    private String hairColor;
    private int age;
    private String email;
    @PrePersist
    public void init() {
        this.id = Objects.isNull(this.id) ? UUID.randomUUID().toString() : this.id;
    }

    public PeopleEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PeopleEntity{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
