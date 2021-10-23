package com.it.cinemabackend.controller;

import com.it.cinemabackend.domain.dto.ImageDTO;
import com.it.cinemabackend.domain.mapper.ModelMapper;
import com.it.cinemabackend.domain.model.Image;
import com.it.cinemabackend.service.ImageService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api")
@Slf4j
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
    private final ModelMapper modelMapper;

    @PostMapping("image")
    public Long uploadImage(@RequestBody MultipartFile file) {
        try {
            byte[] content = file.getBytes();
            Image image = new Image(file.getOriginalFilename(), file.getContentType(), content);
            return imageService.save(image);
        }
        catch (IOException e) {
            log.error("Couldn`t save file due to IOException.", e);
            return -1L;
        }
    }

    @GetMapping("image/{id}")
    public ResponseEntity<ImageDTO> getImageOfId(@PathVariable Long id) {
        ImageDTO image = modelMapper.imageToImageNoId(imageService.findById(id));
        return ResponseEntity.ok(image);
    }
}
