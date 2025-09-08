package com.labo.gestion_stock.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Cathegory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cat;

    @NotNull
    private String type;

    @OneToMany(mappedBy = "cathegory",fetch = FetchType.LAZY)
    private List<Produit> produits;
}
