package com.it.cinemabackend.model.movie;

import com.it.cinemabackend.model.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "technology")
public class Technology extends BaseEntity {

    private String name;

    @OneToMany(
        mappedBy = "technology"
    )
    private Set<Showtime> showtimes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(Set<Showtime> showtimes) {
        this.showtimes = showtimes;
    }
}
