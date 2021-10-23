package com.it.cinemabackend.auth.domain.model;

import com.it.cinemabackend.domain.BaseEntity;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cinema_user")
public class User extends BaseEntity implements UserDetails {

    @Column(name = "first_name", nullable = false)
    @Length(max = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Length(max = 50)
    private String lastName;

    @Column(name = "username", nullable = false)
    @Length(max = 100)
    private String username;

    @Column(name = "password", nullable = false)
    @Length(max = 256)
    private String password;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name = "created_at", nullable = false)
    @Past
    private LocalDateTime createdAt;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    //TODO
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
