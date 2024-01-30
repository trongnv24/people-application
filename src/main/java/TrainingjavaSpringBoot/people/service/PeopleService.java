package TrainingjavaSpringBoot.people.service;

import TrainingjavaSpringBoot.people.dto.request.PeopleRequest;
import TrainingjavaSpringBoot.people.dto.response.PeopleResponse;

public interface PeopleService {
    PeopleResponse create(PeopleRequest request);

    PeopleResponse getById(String id );
}
