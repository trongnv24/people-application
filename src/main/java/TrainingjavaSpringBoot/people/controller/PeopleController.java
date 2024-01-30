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
        log.info(" === Finish api create new people, People id {} :", response.getId());
        return response;
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PeopleResponse getById(@PathVariable("id") String id){
        log.info(" === Start api getById people === ");
        log.info(" ===  String id : {} ==== ", id);
        PeopleResponse response = service.getById(id);
        log.info( " === Finish api getById people, People id {} : ", response.getId());
        return response;
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PeopleResponse update(@RequestBody PeopleRequest request, @PathVariable ("id") String id){
        log.info(" === Start api update people === ");
        log.info(" === Request Body {} :, String id {} :", request, id);
        PeopleResponse response = service.update(request, id);
        log.info(" === Finish api update people, People id {} : === ", response.getId());
        return response;
    }
}
