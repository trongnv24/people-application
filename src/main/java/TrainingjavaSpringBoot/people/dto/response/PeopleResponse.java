package TrainingjavaSpringBoot.people.dto.response;

import TrainingjavaSpringBoot.people.dto.request.PeopleRequest;

public class PeopleResponse extends PeopleRequest {

    private String id;

    public PeopleResponse() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PeopleResponse{" +
                "id='" + id + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", hairColor='" + getHairColor() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
