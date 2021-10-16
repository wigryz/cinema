package com.it.cinemabackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDTO {

    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String portraitPath;
}
