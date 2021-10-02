package com.it.cinemabackend.mappers;

import com.it.cinemabackend.model.domain.Person;
import com.it.cinemabackend.services.MovieService;
import com.it.cinemabackend.services.TechnologyService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component // just to get rid of "no bean of type ... warning"
@Mapper(componentModel = "spring",
    uses = {MovieService.class, TechnologyService.class, ReferenceMapper.class})
public abstract class MovieMapper {
    public abstract Person toEntity(Long id);
}
