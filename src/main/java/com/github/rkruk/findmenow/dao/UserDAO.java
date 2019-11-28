package com.github.rkruk.findmenow.dao;

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
