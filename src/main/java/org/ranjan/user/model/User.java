package org.ranjan.user.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="USER_DETAILS")
public class User {
    @Id
    @Column(name="ID", length = 100)
    @GeneratedValue
    private Long userID;
    @Column(name="NAME", length = 100)
    private String name;
    @Column(name="EMAIL", length = 50)
    private String email;
    @Column(name="ABOUT", length = 500)
    private String about;

    @Transient
    private List<Rating> rating = new ArrayList<>();
}
