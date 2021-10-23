package com.it.cinemabackend.domain.dto;

import lombok.Data;

@Data
public class ImageDTO {

    private String name;
    private String type;
    private byte[] content;
}
