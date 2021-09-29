package com.it.cinemabackend.model.movie;

import com.it.cinemabackend.model.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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

    private String firstName;

    private String secondName;

    private String lastName;

    private String portraitPath;

    @ManyToMany(mappedBy = "directors", cascade = CascadeType.ALL)
    List<Movie> moviesAsDirector = new ArrayList<>();

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
    List<Movie> moviesAsActor = new ArrayList<>();
}
