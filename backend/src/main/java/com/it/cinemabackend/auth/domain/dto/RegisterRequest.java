package com.it.cinemabackend.auth.domain.dto;

import com.it.cinemabackend.auth.domain.dto.validator.Password;
import javax.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class RegisterRequest {

    @Length(max = 50)
    private String firstName;
    @Length(max = 50)
    private String lastName;
    @Length(max = 100)
    private String username;
    @Email
    private String email;
    @Password
    private String password;
    private String role;
}
