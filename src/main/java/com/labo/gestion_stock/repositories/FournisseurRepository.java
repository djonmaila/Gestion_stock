package com.labo.gestion_stock.repositories;

import com.labo.gestion_stock.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    @Query("select f from Fournisseur f where f.immatriculation = :immatriculation")
    Fournisseur getByImmatriculation(@Param("immatriculation") String immatriculation);

    @Query("SELECT distinct f FROM Fournisseur f join f.produits p  WHERE p.cathegory.type = :type")
    List<Fournisseur> getFournisseurByType(@Param("type") String type);

    @Query("select f from Fournisseur f where f.produits is empty ")
    List<Fournisseur> getFounisseurNotFour();

    @Query("select count(*) from Fournisseur f where f.produits is not empty ")
    long countFournisseurFour();

    @Query("SELECT  sum(p.qteStock) FROM Fournisseur f join f.produits  p where f.nameUser = :name")
    long getQuantityOfProductByFour(@Param("name") String name);

}
