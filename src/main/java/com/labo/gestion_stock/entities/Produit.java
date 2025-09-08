package com.labo.gestion_stock.entities;


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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_product;

    @NotNull
    @Column(length = 50)
    private String productName;
    @NotNull
    @Column(length = 200)
    private String designation;
    @NotNull
    private int qteStock;
    @NotNull
    private double prix;

    @ManyToMany(mappedBy = "produits",fetch = FetchType.LAZY)
    private List<Fournisseur> fournisseurs = new ArrayList<>();

    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<ProductCommande> productCommandes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cat")
    @NotNull
    private Cathegory cathegory;
}
