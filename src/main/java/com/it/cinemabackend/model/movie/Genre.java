package com.it.cinemabackend.model.movie;

import com.it.cinemabackend.model.BaseEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private Set<Movie> movies = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
