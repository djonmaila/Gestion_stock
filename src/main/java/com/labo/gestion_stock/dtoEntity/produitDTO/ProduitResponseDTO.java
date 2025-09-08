package com.labo.gestion_stock.dtoEntity.produitDTO;

import com.labo.gestion_stock.entities.Produit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class ProduitResponseDTO {
    private long id;
    private String productName;
    private String designation;
    private int qteStock;
    private double prix;
    private String type;

    
    public ProduitResponseDTO toProductResponse(Produit produit){
        ProduitResponseDTO responseDTO = new ProduitResponseDTO();
        responseDTO.setId(produit.getId_product());
        responseDTO.setPrix(produit.getPrix());
        responseDTO.setType(produit.getCathegory().getType());
        responseDTO.setDesignation(produit.getDesignation());
        responseDTO.setQteStock(produit.getQteStock());
        responseDTO.setProductName(produit.getProductName());

        return responseDTO;
    }
}
