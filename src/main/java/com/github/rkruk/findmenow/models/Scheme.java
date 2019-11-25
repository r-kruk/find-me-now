package com.github.rkruk.findmenow.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "schemes")
public class Scheme extends BaseEntity {

    private String name;
    private String fileName;
    private String description;
    private Boolean active;
}
