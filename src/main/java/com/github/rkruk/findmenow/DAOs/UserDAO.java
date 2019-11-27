package com.github.rkruk.findmenow.DAOs;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class UserDAO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean active;
    private String role;
    private Long placeId;
}
