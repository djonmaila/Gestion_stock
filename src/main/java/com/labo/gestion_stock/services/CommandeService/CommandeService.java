package com.labo.gestion_stock.services.CommandeService;

import com.labo.gestion_stock.dtoEntity.CommandeDTO.CommandeDTO;
import com.labo.gestion_stock.dtoEntity.produitDTO.ProduitResponseDTO;
import com.labo.gestion_stock.entities.Commande;
import com.labo.gestion_stock.entities.Produit;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandeService {
    Commande create(CommandeDTO commandeDTO);
    List<Commande> getAllCommande();
    Commande getById(long id);
    void deleteCommandeById(long id);
    Commande findByNumeroCommande(String numeroCommande);
    List<ProduitResponseDTO> getProduitByNumeroCommande(String numCom);
}
