package com.it.cinemabackend.model.movie;

import com.it.cinemabackend.model.BaseEntity;
import java.util.Set;
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

    @ManyToMany(mappedBy = "directors", cascade = CascadeType.ALL)
    Set<Movie> moviesAsDirector;

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
    Set<Movie> moviesAsActor;

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

    public Set<Movie> getMoviesAsDirector() {
        return moviesAsDirector;
    }

    public void setMoviesAsDirector(Set<Movie> moviesAsDirector) {
        this.moviesAsDirector = moviesAsDirector;
    }

    public Set<Movie> getMoviesAsActor() {
        return moviesAsActor;
    }

    public void setMoviesAsActor(Set<Movie> moviesAsActor) {
        this.moviesAsActor = moviesAsActor;
    }
}
