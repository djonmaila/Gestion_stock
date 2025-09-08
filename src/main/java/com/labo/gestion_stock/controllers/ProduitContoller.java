package com.labo.gestion_stock.controllers;


import com.labo.gestion_stock.dtoEntity.produitDTO.ProduitDTO;
import com.labo.gestion_stock.dtoEntity.produitDTO.ProduitResponseDTO;
import com.labo.gestion_stock.entities.Produit;
import com.labo.gestion_stock.services.produitService.ProduitService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/produit")
public class ProduitContoller {

    private ProduitService produitService;

    public ProduitContoller(ProduitService produitService){
        this.produitService = produitService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<ProduitResponseDTO> create(@RequestBody ProduitDTO produit){
        return ResponseEntity.ok(produitService.createProduct(produit));
    }

    @PostMapping("/create2")
    @Transactional
    public ResponseEntity<ProduitResponseDTO> create2(@RequestBody ProduitDTO produit){
        return ResponseEntity.ok(produitService.createProduct2(produit));
    }

    @PutMapping("/addfournisseur/{immatriculation}/{productName}")
    public ResponseEntity<String> addFounisseur(@PathVariable String immatriculation,@PathVariable String productName){
            produitService.addFournisseurToProduct(immatriculation,productName);
            return ResponseEntity.ok("fournisseur ajouter avec succès");
    }

    @GetMapping("/")
    public ResponseEntity<List<ProduitResponseDTO>> getAll(){
        return ResponseEntity.ok(produitService.getAllProduit());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduit(@PathVariable long id){
        if (produitService.existsById(id)){
            produitService.deleteProduit(id);
            return ResponseEntity.ok("produit supprimé avec succès");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProduitResponseDTO> updateProduit(@PathVariable long id,@RequestBody ProduitDTO produitDTO){
        return ResponseEntity.ok(produitService.updateProduit(id,produitDTO));
    }
    @GetMapping("/{nameProduct}")
    public Produit getById(@PathVariable String nameProduct){
        return produitService.getByProductName(nameProduct);
    }

    @GetMapping("/count")
    public long countProduit(){
        return produitService.nombreProduit();
    }

    @GetMapping("/count/{name}")
    public long countProduit(@PathVariable String name){
        return produitService.countByProductName(name);
    }

    @GetMapping("/allProduct/{name}")
    public ResponseEntity<List<ProduitResponseDTO>> getProductsByName(@PathVariable String name){
        return ResponseEntity.ok(produitService.getProductByType(name));
    }

    @GetMapping("/fourPro/{name}")
    public ResponseEntity<List<ProduitResponseDTO>> getProductsByFournisseurName(@PathVariable String name){
        return ResponseEntity.ok(produitService.getProductsByFournisseurName(name));
    }

    @GetMapping("/produitCommandé")
    public ResponseEntity<List<ProduitResponseDTO>> getProductCommand(){
        return ResponseEntity.ok(produitService.getProductCommand());
    }

}
