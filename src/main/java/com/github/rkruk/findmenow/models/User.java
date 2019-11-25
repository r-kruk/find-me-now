package com.github.rkruk.findmenow.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true, exclude = "password")
@Table(name = "users")
public class User extends BaseEntity {

    private String login;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne
    private Place place;
}
