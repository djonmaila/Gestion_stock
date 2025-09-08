package com.labo.gestion_stock.controllers;

import com.labo.gestion_stock.dtoEntity.productCommandeDTO.ProductCommandeDTO;
import com.labo.gestion_stock.entities.ProductCommande;
import com.labo.gestion_stock.services.productCommandeService.ProductServiceCommande;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/produitCommande")
@AllArgsConstructor
public class ProduitCommandeController {
    private ProductServiceCommande productServiceCommande;

    @PostMapping("/create")
    public ResponseEntity<ProductCommande> createCommander(@RequestBody ProductCommandeDTO commandeDTO){
        return ResponseEntity.ok(productServiceCommande.create(commandeDTO));
    }
}
