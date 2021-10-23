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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "image")
public class Image extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Lob
    @Column(name = "content", nullable = false)
    private byte[] content;

}
