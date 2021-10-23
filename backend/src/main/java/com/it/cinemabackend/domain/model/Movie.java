package com.it.cinemabackend.domain.model;

import com.it.cinemabackend.domain.BaseEntity;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {

    @Column(name = "title",nullable = false)
    @Length(max = 100)
    private String title;

    @Column(name = "short_description", nullable = true)
    @Length(max = 255)
    private String shortDescription;

    @Column(name = "description", nullable = true)
    @Length(max = 65535)
    private String description;

    @Column(name = "year_of_production", nullable = true)
    private Integer yearOfProduction;

    @Column(name = "duration", nullable = true)
    private Integer duration;

    @Column(name = "age_restriction", nullable = true)
    private Integer ageRestriction;

    @Column(name = "poster_path", nullable = true)
    @Length(max = 100)
    private String posterPath;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Showtime> showtimes;

    @ManyToMany
    @JoinTable(name = "movie_genre", joinColumns = {
        @JoinColumn(name = "movie_id")}, inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "movie_director", joinColumns = {
        @JoinColumn(name = "movie_id")}, inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> directors;

    @ManyToMany
    @JoinTable(name = "movie_actor", joinColumns = {
        @JoinColumn(name = "movie_id")}, inverseJoinColumns = @JoinColumn(name = "person_id"))
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
            ", genres=" + genres.stream().map(BaseEntity::getId).toList() +
            ", directors=" + directors.stream().map(BaseEntity::getId).toList() +
            ", actors=" + actors.stream().map(BaseEntity::getId).toList() +
            '}';
    }
}
