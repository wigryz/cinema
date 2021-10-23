package com.it.cinemabackend.service;

import com.it.cinemabackend.domain.model.Image;
import com.it.cinemabackend.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public Long save(Image image) {
        return imageRepository.save(image).getId();
    }

    public Image findById(Long id) {
        return imageRepository.findById(id).orElseThrow();
    }
}
