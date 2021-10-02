package com.it.cinemabackend.model.domain;

import com.it.cinemabackend.model.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    private String secondName;

    @Column(nullable = false)
    private String lastName;

    private String portraitPath;

    @ManyToMany(mappedBy = "directors", cascade = CascadeType.ALL)
    List<Movie> moviesAsDirector = new ArrayList<>();

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
    List<Movie> moviesAsActor = new ArrayList<>();

    @Override
    public String toString() {
        return "Person{" +
            "id='" + getId() + '\'' +
            "firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", portraitPath='" + portraitPath + '\'' +
            '}';
    }
}
