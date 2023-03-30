package com.example.webflux.Services;

import com.example.webflux.Dto.PersonDto;
import com.example.webflux.Entities.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    Flux<PersonDto> getAllPersons();

    Mono<PersonDto> updatePerson(Long id, Mono<PersonDto> personDto);

    Mono<Void> deletePerson(long id);

    Mono<PersonDto> addPerson(Mono<PersonDto> personDto);

    Mono<PersonDto> getById(Long id);
}
