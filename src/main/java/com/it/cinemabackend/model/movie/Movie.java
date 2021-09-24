package com.it.cinemabackend.model.movie;

import com.it.cinemabackend.model.BaseEntity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {

    private String title;

    @Lob
    private String description;

    private Integer yearOfProduction;

    private Integer duration;

    private String additionalInfo;

    private Integer ageRestriction;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Showtime> showtimes;

    @ManyToMany
    @JoinTable(name = "movie_genre", joinColumns = {
            @JoinColumn(name = "genre_id") }, inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(name = "movie_director", joinColumns = {
            @JoinColumn(name = "person_id") }, inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Person> directors;

    @ManyToMany
    @JoinTable(name = "movie_actor", joinColumns = {
            @JoinColumn(name = "person_id") }, inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Person> actors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Set<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(Set<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Person> directors) {
        this.directors = directors;
    }

    public Set<Person> getActors() {
        return actors;
    }

    public void setActors(Set<Person> actors) {
        this.actors = actors;
    }
}
