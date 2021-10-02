package com.it.cinemabackend.model.dto;

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

    private String firstName;
    private String secondName;
    private String lastName;
    private String portraitPath;
}
