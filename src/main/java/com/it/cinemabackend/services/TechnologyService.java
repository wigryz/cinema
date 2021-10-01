package com.it.cinemabackend.services;

import com.it.cinemabackend.model.movie.Technology;
import com.it.cinemabackend.repository.TechnologyRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public Technology findById(Long id) {
        return technologyRepository.findById(id).orElseThrow();
    }

    public List<Technology> findAll() {
        List<Technology> technologies = new ArrayList<>();
        technologyRepository.findAll().forEach(technologies::add);
        return technologies;
    }

    public Technology save(Technology technology) {
        return technologyRepository.save(technology);
    }
}
