package TrainingjavaSpringBoot.people.dto.request;

import jakarta.persistence.PrePersist;

import java.util.Objects;
import java.util.UUID;

public class PeopleRequest {
    private String id;
    private String lastName;
    private String hairColor;
    private int age;
    private String email;

    public PeopleRequest() {
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
