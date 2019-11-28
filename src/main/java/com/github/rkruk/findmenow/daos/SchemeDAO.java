package com.github.rkruk.findmenow.daos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class SchemeDAO {

    private Long id;
    private String name;
    private String fileName;
    private String description;
    private Boolean active;
}
