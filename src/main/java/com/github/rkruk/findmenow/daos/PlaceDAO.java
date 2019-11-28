package com.github.rkruk.findmenow.daos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class PlaceDAO {

    private Long id;
    private String name;
    private String description;
    private Long coordinateX;
    private Long coordinateY;
    private Long schemeId;

}
