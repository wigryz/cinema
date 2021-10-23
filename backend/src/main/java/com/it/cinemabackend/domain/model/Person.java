package com.it.cinemabackend.domain.model;

import com.it.cinemabackend.domain.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
@Table(name = "person")
public class Person extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    @Length(max = 20)
    private String firstName;

    @Column(name = "second_name", nullable = true)
    @Length(max = 20)
    private String secondName;

    @Column(name = "last_name", nullable = false)
    @Length(max = 20)
    private String lastName;

    @Column(name = "portrait_path", nullable = true)
    @Length(max = 100)
    private String portraitPath;

    @ManyToMany(mappedBy = "directors", cascade = CascadeType.ALL)
    private List<Movie> moviesAsDirector = new ArrayList<>();

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
    private List<Movie> moviesAsActor = new ArrayList<>();

    @Override
    public String toString() {
        return "Person{" +
            "id='" + getId() + '\'' +
            "firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", portraitPath='" + portraitPath + '\'' +
            '}';
    }
}
