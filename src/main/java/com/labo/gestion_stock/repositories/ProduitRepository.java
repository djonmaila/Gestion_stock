package com.labo.gestion_stock.repositories;

import com.labo.gestion_stock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    Produit findByProductName(String productName);
    long countByProductName(String productName);

    @Query("SELECT  p From Produit p where p.cathegory.type = :type")
    List<Produit> getProductByType(@Param("type") String type);

    @Query("SELECT distinct p FROM Produit p join p.fournisseurs f  WHERE f.nameUser = :nameFour")
    List<Produit> getProductsByFournisseurName(@Param("nameFour") String nameFour);

    @Query("select p from Produit p join p.productCommandes com where com.produit is not null ")
    List<Produit> getProductCommand();
}
