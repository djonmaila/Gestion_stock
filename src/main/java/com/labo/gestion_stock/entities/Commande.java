package com.labo.gestion_stock.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_commande;

    @Column(length = 10,unique = true)
    @NotNull
    private String numeroCommande;

    @OneToMany(mappedBy = "commande",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<ProductCommande> commandes;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
