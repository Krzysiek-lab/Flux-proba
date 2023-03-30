package com.example.webflux.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Person")
@Builder
@NoArgsConstructor
public class Person {

    @Id
    private Long id;
    private String name;
    private String password;

}
