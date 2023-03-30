package com.example.demo.Entities;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Person {

    private Long id;
    private String name;
    private String password;

}
