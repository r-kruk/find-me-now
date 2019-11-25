package com.github.rkruk.findmenow.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name="places")
public class Place extends BaseEntity {

    private String name;
    private String description;
    @ManyToOne
    private Scheme scheme;
    @Column(name="coordinate_x")
    private Long coordinateX;
    @Column(name="coordinate_y")
    private Long coordinateY;

}
