package TrainingjavaSpringBoot.people.service.Impl;

import TrainingjavaSpringBoot.people.dto.request.PeopleRequest;
import TrainingjavaSpringBoot.people.dto.response.PeopleResponse;
import TrainingjavaSpringBoot.people.entity.PeopleEntity;
import TrainingjavaSpringBoot.people.repository.PeopleRepository;
import TrainingjavaSpringBoot.people.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static TrainingjavaSpringBoot.people.service.mapping.PeopleMapping.convertDtoToEntity;
import static TrainingjavaSpringBoot.people.service.mapping.PeopleMapping.convertEntityToPeopleResponse;

@Service
@Slf4j
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Override
    public PeopleResponse create(PeopleRequest request) {
        log.info(" === Start api create new people === ");
        log.info(" === Request Body {} : === ", request);
        PeopleEntity peopleEntity = convertDtoToEntity(request);
        peopleEntity = peopleRepository.save(peopleEntity);
        PeopleResponse response = convertEntityToPeopleResponse(peopleEntity);
        log.info(" === Finish api create new people, People id ", response.getId());
        return response;
    }
}