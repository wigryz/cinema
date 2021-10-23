package com.it.cinemabackend.domain.model;

import com.it.cinemabackend.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "image")
public class Image extends BaseEntity {

    @Column(name = "name", nullable = false)
    @Length(max = 100)
    private String name;

    @Column(name = "type", nullable = false)
    @Length(max = 20)
    private String type;

    @Lob
    @Column(name = "content", nullable = false)
    private byte[] content;

}
