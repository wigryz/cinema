package com.it.cinemabackend.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.it.cinemabackend.domain.model.Technology;
import com.it.cinemabackend.repository.TechnologyRepository;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TechnologyServiceTest {

    TechnologyService technologyService;
    @Mock
    TechnologyRepository technologyRepository;

    List<Technology> givenTechnologies;

    Technology t1;
    Technology t2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        technologyService = new TechnologyService(technologyRepository);
        t1 = new Technology("tech1", Collections.emptyList());
        t2 = new Technology("tech2", Collections.emptyList());
        t1.setId(1L);
        t2.setId(2L);
        givenTechnologies = List.of(t1, t2);
    }

    @Test
    void findById() {
        when(technologyRepository.findById(1L)).thenReturn(Optional.of(t1));
        Technology technology = technologyService.findById(1L);
        assertThat(technology.getName()).isEqualTo("tech1");
    }

    @Test
    void findByIdFail() {
        when(technologyRepository.findById(any())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> technologyService.findById(1L))
            .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void findAll() {
        when(technologyRepository.findAll()).thenReturn(givenTechnologies);
        List<Technology> technologies = technologyService.findAll();
        assertThat(technologies.size()).isEqualTo(technologies.size());
    }

    @Test
    void save() {
        Technology technology = new Technology();
        when(technologyRepository.save(any(Technology.class))).thenReturn(technology);
        Technology created = technologyService.save(technology);
        assertThat(created.getName()).isEqualTo(technology.getName());
    }
}
