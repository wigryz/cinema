package com.it.cinemabackend.auth.domain.dto;

import lombok.Data;

@Data
public class AuthRequest {

    String username;
    String password;
}
