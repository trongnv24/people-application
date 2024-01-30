package TrainingjavaSpringBoot.people.service.Impl;

import TrainingjavaSpringBoot.people.dto.request.PeopleRequest;
import TrainingjavaSpringBoot.people.dto.response.PeopleResponse;
import TrainingjavaSpringBoot.people.entity.PeopleEntity;
import TrainingjavaSpringBoot.people.repository.PeopleRepository;
import TrainingjavaSpringBoot.people.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public PeopleResponse getById(String id) {
        log.info(" === Start api getById people ==== ");
        log.info(" === String id {} : === ", id);
        Optional<PeopleEntity>optionalPeople = peopleRepository.findById(id);
        if(!optionalPeople.isPresent()){
            throw new RuntimeException();
        }
        PeopleEntity peopleEntity = optionalPeople.get();
        PeopleResponse response = convertEntityToPeopleResponse(peopleEntity);
        log.info(" === Finish api getById people ===, People id {} : ", response.getId());
        return response;
    }

    @Override
    public PeopleResponse update(PeopleRequest request, String id) {
        log.info(" === Start api update people === ");
        log.info(" === Request Body {} :, String id {} : ",request,id);
        Optional<PeopleEntity>optionalPeople=peopleRepository.findById(id);
        if(!optionalPeople.isPresent()){
            throw new RuntimeException();
        }
        PeopleEntity peopleEntity = optionalPeople.get();
        peopleEntity.setLastName(request.getLastName());
        peopleEntity.setHairColor(request.getHairColor());
        peopleEntity.setAge(request.getAge());
        peopleEntity.setEmail(request.getEmail());
        peopleEntity = peopleRepository.save(peopleEntity);
        PeopleResponse response = convertEntityToPeopleResponse(peopleEntity);
        log.info(" === Finish api update people, People id {} : === ", response.getId());
        return response;
    }

    @Override
    public void deleteById(String id) {
        log.info(" === Start api delete people === ");
        log.info(" === String id {} : ==== ");
        Optional<PeopleEntity>optionalPeople=peopleRepository.findById(id);
        if(!optionalPeople.isPresent()){
            throw new RuntimeException();
        }
        log.info(" === Finish api delete people, People id {} : ==== ");
        peopleRepository.deleteById(id);
    }
}
