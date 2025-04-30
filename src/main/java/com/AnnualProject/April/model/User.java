package com.AnnualProject.April.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String email;



    @Enumerated(EnumType.STRING)
    private Role role;
}
