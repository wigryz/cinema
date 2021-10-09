package com.it.cinemabackend.services;

import com.it.cinemabackend.model.domain.Technology;
import com.it.cinemabackend.repository.TechnologyRepository;
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
        return technologyRepository.findAll();
    }

    public Technology save(Technology technology) {
        return technologyRepository.save(technology);
    }
}
