package com.example.webflux.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class PersonDto {

    @NotNull
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

}
