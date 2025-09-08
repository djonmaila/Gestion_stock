package com.labo.gestion_stock.services.productCommandeService;

import com.labo.gestion_stock.dtoEntity.productCommandeDTO.ProductCommandeDTO;
import com.labo.gestion_stock.entities.Commande;
import com.labo.gestion_stock.entities.ProductCommande;
import com.labo.gestion_stock.entities.Produit;
import com.labo.gestion_stock.repositories.ProductCommandeRepository;
import com.labo.gestion_stock.services.CommandeService.CommandeService;
import com.labo.gestion_stock.services.produitService.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@AllArgsConstructor
public class ProductServiceCommandeImpl implements ProductServiceCommande{
    private ProductCommandeRepository productCommandeRepository;
    private CommandeService commandeService;
    private ProduitService produitService;
    @Override
    public ProductCommande create(ProductCommandeDTO dto) {
        ProductCommande commande = new ProductCommande();

        commande.setDate(LocalDate.now());
        commande.setTime(LocalTime.now());
        commande.setQteCommande(dto.getQteCommande());

        Commande com = commandeService.findByNumeroCommande(dto.getNumCom());
        commande.setCommande(com);

        Produit produit = produitService.getByProductName(dto.getProductName());
        commande.setProduit(produit);

        productCommandeRepository.save(commande);

        return null;
    }
}
