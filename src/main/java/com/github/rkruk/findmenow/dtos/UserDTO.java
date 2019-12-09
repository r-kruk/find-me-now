package com.github.rkruk.findmenow.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class UserDTO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean active;
    private String role;
    private List<Long> placesId;
}
