package com.github.rkruk.findmenow.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class SchemeDTO {

    private Long id;
    private String name;
    private String fileName;
    private String description;
    private Boolean active;
}
