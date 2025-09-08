package com.labo.gestion_stock.controllers;

import com.labo.gestion_stock.dtoEntity.fournisseurDTO.FournisseurDTO;
import com.labo.gestion_stock.dtoEntity.fournisseurDTO.FournisseurResponseDTO;
import com.labo.gestion_stock.entities.Fournisseur;
import com.labo.gestion_stock.services.fournisseurService.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/fournisseur")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @PostMapping("/create")
    public ResponseEntity<FournisseurResponseDTO> createFournisseur(@RequestBody FournisseurDTO fournisseur){
        return ResponseEntity.ok(fournisseurService.createFournisseur(fournisseur));
    }

    @GetMapping("/")
    public ResponseEntity<List<FournisseurResponseDTO>> getAllFour(){
        return ResponseEntity.ok(fournisseurService.getAllFournisseur());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFournisseur(@PathVariable long id){
        fournisseurService.deleteById(id);
        return ResponseEntity.ok("fournisseur supprimer avec succès");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FournisseurResponseDTO> updateFour(@PathVariable long id,@RequestBody FournisseurDTO fournisseurDTO){
        return ResponseEntity.ok(fournisseurService.updateFounisseur(id,fournisseurDTO));
    }

    @GetMapping("/type/{typeName}")
    public ResponseEntity<List<Fournisseur>> getFournisseurType(@PathVariable String typeName){
        return ResponseEntity.ok(fournisseurService.getFournisseurByType(typeName));
    }

    @GetMapping("/fourNull")
    public ResponseEntity<List<Fournisseur>> getFounisseurNotFour(){
        return ResponseEntity.ok(fournisseurService.getFounisseurNotFour());
    }

    @GetMapping("/countFournisseurFour")
    public ResponseEntity<Long> getFounisseurCountFour(){
        return ResponseEntity.ok(fournisseurService.countFournisseurFour());
    }

    @GetMapping("/quantityLivre/{name}")
    public ResponseEntity<Long> getQuantityProductFour(@PathVariable String name){
        return ResponseEntity.ok(fournisseurService.getQuantityOfProductByFour(name));
    }

}
