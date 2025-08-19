package com.labo.gestion_stock.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;
    @Column(length = 25)
    @NotNull
    private String nameUser;
    @Column(length = 35)
    @NotNull
    private String email;
    @Column(length = 9)
    @NotNull
    private String numTel;
    @Column(length = 35)
    @NotNull
    private String password;
}
