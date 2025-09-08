package com.labo.gestion_stock.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@DiscriminatorValue("fournisseur")
public class Fournisseur extends User{
    @NotNull
    private String referrence;
    @NotNull
    @Column(unique = true)
    private String immatriculation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "fourisseur_produit",
            joinColumns = @JoinColumn(name = "id_fournisseur"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    @JsonIgnore
    private List<Produit> produits = new ArrayList<>();
}
