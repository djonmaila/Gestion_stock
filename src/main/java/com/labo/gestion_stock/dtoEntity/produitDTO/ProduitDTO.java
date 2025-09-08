package com.labo.gestion_stock.dtoEntity.produitDTO;

import com.labo.gestion_stock.entities.Cathegory;
import com.labo.gestion_stock.entities.Fournisseur;
import com.labo.gestion_stock.entities.Produit;
import com.labo.gestion_stock.repositories.CategoriRepository;
import com.labo.gestion_stock.repositories.FournisseurRepository;
import com.labo.gestion_stock.services.categorieService.CategoryService;
import com.labo.gestion_stock.services.fournisseurService.FournisseurService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class ProduitDTO {
    private String productName;
    private String designation;
    private int qteStock;
    private double prix;
    private String type;
    private String immatriculation;
    @Autowired
    private CategoriRepository categoryService;
    @Autowired
    private FournisseurRepository fournisseurService;

    @Transactional
    public Produit toProduct(ProduitDTO produitDTO) throws Exception{
        Produit p = new Produit();
        p.setProductName(produitDTO.getProductName());
        p.setDesignation(produitDTO.getDesignation());
        p.setQteStock(produitDTO.getQteStock());
        Cathegory cathegory = categoryService.findByType(produitDTO.getType());
        if (cathegory == null){
            throw new ClassNotFoundException("categorie incorrecte");
        }
        p.setPrix(produitDTO.getPrix());
        p.setCathegory(cathegory);

        Fournisseur fournisseur = fournisseurService.getByImmatriculation(produitDTO.immatriculation);
        p.getFournisseurs().add(fournisseur);

        return p;
    }
}
