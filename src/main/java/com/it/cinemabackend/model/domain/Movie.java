package com.it.cinemabackend.model.domain;

import com.it.cinemabackend.model.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "movie")
public class Movie extends BaseEntity {

    @Column(nullable = false)
    private String title;

    private String shortDescription;

    private String description;

    private Integer yearOfProduction;

    private Integer duration;

    private Integer ageRestriction;

    private String posterPath;

    private String imdbId;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Showtime> showtimes;

    @ManyToMany
    @JoinTable(name = "movie_genre", joinColumns = {
            @JoinColumn(name = "movie_id") }, inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "movie_director", joinColumns = {
            @JoinColumn(name = "movie_id") }, inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> directors;

    @ManyToMany
    @JoinTable(name = "movie_actor", joinColumns = {
            @JoinColumn(name = "movie_id") }, inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> actors;

    @Override
    public String toString() {
        return "Movie{" +
            "id='" + getId() + '\'' +
            "title='" + title + '\'' +
            ", shortDescription='" + shortDescription + '\'' +
            ", description='" + description + '\'' +
            ", yearOfProduction=" + yearOfProduction +
            ", duration=" + duration +
            ", ageRestriction=" + ageRestriction +
            ", posterPath='" + posterPath + '\'' +
            ", imdbId='" + imdbId + '\'' +
            ", genres=" + genres.stream().map(BaseEntity::getId).toList() +
            ", directors=" + directors.stream().map(BaseEntity::getId).toList() +
            ", actors=" + actors.stream().map(BaseEntity::getId).toList() +
            '}';
    }
}
