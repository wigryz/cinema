package com.it.cinemabackend.auth.domain.model;

import com.it.cinemabackend.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";

    @Column(name = "name")
    private String name;

    public String getAuthority() {
        return name;
    }

    public void setAuthority(String name) {
        this.name = name;
    }
}
