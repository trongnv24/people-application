package TrainingjavaSpringBoot.people.service.mapping;

import TrainingjavaSpringBoot.people.dto.request.PeopleRequest;
import TrainingjavaSpringBoot.people.dto.response.PeopleResponse;
import TrainingjavaSpringBoot.people.entity.PeopleEntity;

public class PeopleMapping {

    public static PeopleEntity convertDtoToEntity(PeopleRequest dto ){
        PeopleEntity entity = new PeopleEntity();
        entity.setLastName(dto.getLastName());
        entity.setHairColor(dto.getHairColor());
        entity.setAge(dto.getAge());
        entity.setEmail(dto.getEmail());
        return entity;
    }
    public static PeopleResponse convertEntityToPeopleResponse(PeopleEntity entity){
        PeopleResponse dto = new PeopleResponse();
        dto.setId(entity.getId());
        dto.setLastName(entity.getLastName());
        dto.setHairColor(entity.getHairColor());
        dto.setAge(entity.getAge());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
