package com.example.demo.Client;


import com.example.demo.Dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class WebClientAppImpl {

    WebClient webClient = WebClient.create("http://localhost:9090");
    private final String BASE_URL = "/person";

    @Bean
    public Flux<PersonDto> getAllPersons() {
        Flux<PersonDto> personDtoFlux = webClient.get()
                .uri(BASE_URL + "/getAll")
                .retrieve()
                .bodyToFlux(PersonDto.class).delayElements(Duration.ofSeconds(1));
        personDtoFlux.subscribe(System.out::println);
        return personDtoFlux;
    }

    public Mono<PersonDto> getPersonById(Long id) {
        return webClient.get()
                .uri(BASE_URL + "/getById/" + id)
                .retrieve()
                .bodyToMono(PersonDto.class);
    }

    public Mono<PersonDto> addPerson(PersonDto personDto) {
        return webClient.post()
                .uri(BASE_URL + "/add")
                .body(Mono.just(personDto), PersonDto.class)
                .retrieve()
                .bodyToMono(PersonDto.class);
    }

    public Mono<PersonDto> updatePerson(Long id, PersonDto personDto) {
        return webClient.post()
                .uri(BASE_URL + "/update/" + id)
                .body(Mono.just(personDto), PersonDto.class)
                .retrieve()
                .bodyToMono(PersonDto.class);
    }

    public Mono<Void> deletePerson(Long id) {
        return webClient.delete()
                .uri(BASE_URL + "/delete/" + id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
