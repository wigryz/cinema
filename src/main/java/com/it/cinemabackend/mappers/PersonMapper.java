package com.it.cinemabackend.mappers;

import com.it.cinemabackend.model.dto.PersonDTO;
import com.it.cinemabackend.model.movie.Person;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component // just to get rid of "no bean of type ... warning"
@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO personToPersonDTO(Person person);
}
