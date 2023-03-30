package com.example.webflux.Mapper;

import com.example.webflux.Dto.PersonDto;
import com.example.webflux.Entities.Person;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public PersonDto personToDto(Person person) {
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(person, personDto);
        return personDto;
//        return PersonDto.builder()
//                .id(person.getId())
//                .name(person.getName())
//                .password(person.getPassword())
//                .build();
    }


    public Person personDtoToPerson(PersonDto persondto) {
//        return Person.builder()
//                .id(persondto.getId())
//                .name(persondto.getName())
//                .password(persondto.getPassword())
//                .build();

        Person person = new Person();
        BeanUtils.copyProperties(persondto, person);
        return person;
    }
}
