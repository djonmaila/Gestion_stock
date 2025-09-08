package com.labo.gestion_stock.repositories;

import com.labo.gestion_stock.entities.ProductCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductCommandeRepository extends JpaRepository<ProductCommande,Long> {
    @Query("delete from ProductCommande p where p.commande.id_commande is null and p.produit.id_product is null")
    public void deleteById_ComAndIdçPro();
}
