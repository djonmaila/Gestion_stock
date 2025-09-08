package com.labo.gestion_stock.repositories;

import com.labo.gestion_stock.entities.Commande;
import com.labo.gestion_stock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Commande findByNumeroCommande(String numeroCommande);
    //la liste des produits contenu dans une commande donnée
    @Query("select pro from Commande c join c.commandes p join p.produit pro where c.numeroCommande = :numCom")
    List<Produit> getProduitByNumeroCommande(@Param("numCom") String numCom);
}
