package TrainingjavaSpringBoot.people.controller;

import TrainingjavaSpringBoot.people.dto.request.PeopleRequest;
import TrainingjavaSpringBoot.people.dto.response.PeopleResponse;
import TrainingjavaSpringBoot.people.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
@Slf4j
public class PeopleController {
    private final PeopleService service;

    public PeopleController(PeopleService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeopleResponse create(@RequestBody PeopleRequest request){
        log.info(" === Start api create new people === ");
        log.info((" === Request Body : {} ==== "), request);
        PeopleResponse response = service.create(request);
        return response;
    }
}
