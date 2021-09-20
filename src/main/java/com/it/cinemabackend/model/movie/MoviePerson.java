package com.it.cinemabackend.model.movie;

import com.it.cinemabackend.model.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie_people")
public class MoviePerson extends BaseEntity {

    @ManyToOne
    Person person;

    @ManyToOne
    Movie movie;

    ParticipationType participationType;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ParticipationType getParticipationType() {
        return participationType;
    }

    public void setParticipationType(ParticipationType participationType) {
        this.participationType = participationType;
    }

    enum ParticipationType {
        ACTOR, ACTRESS, DIRECTOR
    }
}
