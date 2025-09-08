package com.labo.gestion_stock.controllers;

import com.labo.gestion_stock.dtoEntity.CommandeDTO.CommandeDTO;
import com.labo.gestion_stock.dtoEntity.produitDTO.ProduitResponseDTO;
import com.labo.gestion_stock.entities.Commande;
import com.labo.gestion_stock.services.CommandeService.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/commande")
@AllArgsConstructor
public class CommandController {
    private CommandeService commandeService;

    @PostMapping("/create")
    public ResponseEntity<Commande> createCommande(@RequestBody CommandeDTO commandeDTO){
        return ResponseEntity.ok(commandeService.create(commandeDTO));
    }

    @GetMapping("/listCommande")
    public ResponseEntity<List<Commande>> getAllCommande(){
        return ResponseEntity.ok(commandeService.getAllCommande());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getById(@PathVariable long id){
        return ResponseEntity.ok(commandeService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        commandeService.deleteCommandeById(id);
        return ResponseEntity.ok("Commande supprimé avec succès");
    }

    @GetMapping("/byNumCom/{numcom}")
    public ResponseEntity<List<ProduitResponseDTO>> getProductsByNumCommande(@PathVariable String numcom){
        return ResponseEntity.ok(commandeService.getProduitByNumeroCommande(numcom));
    }
}
