package com.it.cinemabackend.auth.domain;

import com.it.cinemabackend.model.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";

    @Column(name = "name")
    private String authority;


}
