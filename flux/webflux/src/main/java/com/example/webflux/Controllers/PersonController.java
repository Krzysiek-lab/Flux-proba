package com.example.webflux.Controllers;

import com.example.webflux.Dto.PersonDto;
import com.example.webflux.Entities.Person;
import com.example.webflux.Repositories.PersonRepository;
import com.example.webflux.Services.PersonServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private PersonServiceImpl personService;

    @GetMapping(value = "/getAll")
    public Flux<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "/getById/")
    public Mono<PersonDto> getPersonById(@RequestParam Long id) {
        return personService.getById(id);
    }

    @PostMapping(value = "/add")
    public Mono<PersonDto> addPerson(@RequestBody @Valid PersonDto personDto) {
        return personService.addPerson(Mono.just(personDto));
    }

    @PutMapping(value = "/update/")
    public Mono<PersonDto> updatePerson(@RequestParam Long id, @RequestBody @Valid PersonDto personDto) {
        return personService.updatePerson(id, Mono.just(personDto));
    }

    @DeleteMapping(value = "/delete/")
    public Mono<Void> deletePersons(@RequestParam Long id) {
        return personService.deletePerson(id);
    }
}
