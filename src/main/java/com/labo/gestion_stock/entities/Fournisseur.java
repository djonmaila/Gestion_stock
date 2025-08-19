package com.labo.gestion_stock.entities;


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
public class Fournisseur{
    @Id
    private String referrence;
    @NotNull
    private String immatriculation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "fourisseur_produit",
            joinColumns = @JoinColumn(name = "id_fournisseur"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private List<Produit> produits;
}
