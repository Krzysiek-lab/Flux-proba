package com.example.webflux.Services;

import com.example.webflux.Dto.PersonDto;
import com.example.webflux.Mapper.PersonMapper;
import com.example.webflux.Repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public Flux<PersonDto> getAllPersons() {
        return personRepository.findAll().map(personMapper::personToDto);
    }

    @Override
    public Mono<PersonDto> getById(Long id) {
        return personRepository.findById(id).map(personMapper::personToDto);
    }

    @Override
    public Mono<PersonDto> addPerson(Mono<PersonDto> personDto) {
        return personDto.map(personMapper::personDtoToPerson)
                .flatMap(personRepository::insert)
                .map(personMapper::personToDto);
    }

    @Override
    public Mono<PersonDto> updatePerson(Long id, Mono<PersonDto> personDto) {
        return personRepository.findById(id)
                .flatMap(e -> personDto.map(personMapper::personDtoToPerson)
                        .doOnNext(q -> q.setId(id)))
                .flatMap(personRepository::save)
                .map(personMapper::personToDto);
    }

    @Override
    public Mono<Void> deletePerson(long id) {
        return personRepository.deleteById(id);
    }
}
