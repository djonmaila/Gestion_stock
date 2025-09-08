package com.labo.gestion_stock.services.CommandeService;

import com.labo.gestion_stock.dtoEntity.CommandeDTO.CommandeDTO;
import com.labo.gestion_stock.dtoEntity.produitDTO.ProduitResponseDTO;
import com.labo.gestion_stock.entities.Commande;
import com.labo.gestion_stock.entities.ProductCommande;
import com.labo.gestion_stock.entities.Produit;
import com.labo.gestion_stock.entities.User;
import com.labo.gestion_stock.repositories.CommandeRepository;
import com.labo.gestion_stock.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommandeServiceImpl implements CommandeService{
    private CommandeRepository commandeRepository;
    private UserRepository userRepository;

    @Override
    public Commande create(CommandeDTO commandeDTO) {
        User user = userRepository.findByNameUser(commandeDTO.getUserName());
        if (user==null){
            throw new RuntimeException("Impossible requiet un user existant");
        }

        Commande commande = new Commande();
        commande.setNumeroCommande(commandeDTO.getNumeroCommande());
        commande.setUser(user);

        return commandeRepository.save(commande);

    }

    @Override
    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getById(long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public void deleteCommandeById(long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public Commande findByNumeroCommande(String numeroCommande) {
        return commandeRepository.findByNumeroCommande(numeroCommande);
    }

    @Override
    public List<ProduitResponseDTO> getProduitByNumeroCommande(String numCom) {
        List<Produit> produits = commandeRepository.getProduitByNumeroCommande(numCom);
        List<ProduitResponseDTO> produitResponseDTOS = new ArrayList<>();
        for (Produit p : produits){
            produitResponseDTOS.add(new ProduitResponseDTO(
                    p.getId_product(),
                    p.getProductName(),
                    p.getDesignation(),
                    p.getQteStock(),
                    p.getPrix(),
                    p.getCathegory().getType()
            ));
        }
        return produitResponseDTOS;
    }
}
