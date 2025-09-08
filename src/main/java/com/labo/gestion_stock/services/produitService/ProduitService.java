package com.labo.gestion_stock.services.produitService;

import com.labo.gestion_stock.dtoEntity.produitDTO.ProduitDTO;
import com.labo.gestion_stock.dtoEntity.produitDTO.ProduitResponseDTO;
import com.labo.gestion_stock.entities.Produit;

import java.util.List;

public interface ProduitService {
    ProduitResponseDTO createProduct(ProduitDTO produit);
    List<ProduitResponseDTO> getAllProduit();
    Produit getByProductName(String productName);
    void deleteProduit(long id);
    boolean existsById(long id);
    ProduitResponseDTO updateProduit(long id,ProduitDTO produitDTO);
    long nombreProduit();
    long countByProductName(String name);
    void addFournisseurToProduct(String immatriculation,String productName);
    ProduitResponseDTO createProduct2(ProduitDTO produit);
    List<ProduitResponseDTO> getProductByType(String type);

    List<ProduitResponseDTO> getProductsByFournisseurName(String nameFour);
    List<ProduitResponseDTO> getProductCommand();
}
