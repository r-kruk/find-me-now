package com.github.rkruk.findmenow.DAOs;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class UserDAO {

    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private Long placeId;
}
