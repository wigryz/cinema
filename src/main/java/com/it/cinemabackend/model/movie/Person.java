package com.it.cinemabackend.model.movie;

import com.it.cinemabackend.model.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPortraitPath() {
        return portraitPath;
    }

    public void setPortraitPath(String portraitPath) {
        this.portraitPath = portraitPath;
    }

    public List<Movie> getMoviesAsDirector() {
        return moviesAsDirector;
    }

    public void setMoviesAsDirector(List<Movie> moviesAsDirector) {
        this.moviesAsDirector = moviesAsDirector;
    }

    public List<Movie> getMoviesAsActor() {
        return moviesAsActor;
    }

    public void setMoviesAsActor(List<Movie> moviesAsActor) {
        this.moviesAsActor = moviesAsActor;
    }

}
