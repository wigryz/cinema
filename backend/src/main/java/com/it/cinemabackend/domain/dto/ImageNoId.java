package com.it.cinemabackend.domain.dto;

import lombok.Data;

@Data
public class ImageNoId {

    private String name;
    private String type;
    private byte[] content;
}
