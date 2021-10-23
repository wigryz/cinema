package com.it.cinemabackend.domain.model;

import com.it.cinemabackend.domain.BaseEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "technology")
public class Technology extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "technology")
    private List<Showtime> showtimes;

    @Override
    public String toString() {
        return "Technology{" +
            "id='" + getId() + '\'' +
            "name='" + name + '\'' +
            '}';
    }
}
