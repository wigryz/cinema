package com.it.cinemabackend.domain.model;

import com.it.cinemabackend.domain.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "showtime")
public class Showtime extends BaseEntity {

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "technology_id")
    private Technology technology;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Override
    public String toString() {
        return "Showtime{" +
            "id='" + getId() + '\'' +
            "movie=" + movie +
            ", dateTime=" + dateTime +
            ", technology=" + technology +
            ", language=" + language +
            '}';
    }
}
