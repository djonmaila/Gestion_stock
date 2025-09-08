package com.labo.gestion_stock.services.produitService;

import com.labo.gestion_stock.dtoEntity.produitDTO.ProduitDTO;
import com.labo.gestion_stock.dtoEntity.produitDTO.ProduitResponseDTO;
import com.labo.gestion_stock.entities.Cathegory;
import com.labo.gestion_stock.entities.Fournisseur;
import com.labo.gestion_stock.entities.ProductCommande;
import com.labo.gestion_stock.entities.Produit;
import com.labo.gestion_stock.repositories.CategoriRepository;
import com.labo.gestion_stock.repositories.FournisseurRepository;
import com.labo.gestion_stock.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private ProduitRepository produitRepository;
    private CategoriRepository categoriRepository;
    private FournisseurRepository fournisseurRepository;
    private ProduitResponseDTO produitResponseDTO;


    @Override
    public ProduitResponseDTO createProduct(ProduitDTO produit) {

        Produit pro = new Produit();

        pro.setProductName(produit.getProductName());
        pro.setPrix(produit.getPrix());
        pro.setQteStock(produit.getQteStock());
        pro.setDesignation(produit.getDesignation());

        Cathegory cathegory = categoriRepository.findByType(produit.getType());
        pro.setCathegory(cathegory);

        Fournisseur fournisseur = fournisseurRepository.getByImmatriculation(produit.getImmatriculation());
        fournisseur.getProduits().add(pro);

        return produitResponseDTO.toProductResponse(produitRepository.save(pro));
    }

    @Override
    public List<ProduitResponseDTO> getAllProduit() {
        return new ArrayList<>(produitRepository.findAll().stream().map(produit -> produitResponseDTO.toProductResponse(produit)).toList());
    }

    @Override
    public Produit getByProductName(String productName) {
        return produitRepository.findByProductName(productName);
    }

    @Override
    public void deleteProduit(long id) {
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit == null) throw new RuntimeException("produit inexistant : supression impossible");

        List<Fournisseur> fournisseurs = produit.getFournisseurs();

        for (Fournisseur f : fournisseurs){
            f.getProduits().remove(produit);
        }

        produitRepository.deleteById(id);
    }

    @Override
    public boolean existsById(long id) {
        return produitRepository.existsById(id);
    }

    @Override
    public ProduitResponseDTO updateProduit(long id, ProduitDTO produitDTO) {
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit == null){
            throw new RuntimeException("mise à jour impossible");
        }
        produit.setProductName(produitDTO.getProductName());
        produit.setDesignation(produitDTO.getDesignation());
        produit.setQteStock(produitDTO.getQteStock());
        produit.setPrix(produitDTO.getPrix());
        produit.setCathegory(categoriRepository.findByType(produitDTO.getType()));
        return produitResponseDTO.toProductResponse(produitRepository.save(produit));
    }

    @Override
    public long nombreProduit() {
        return 0;
    }

    @Override
    public long countByProductName(String name) {
        return produitRepository.countByProductName(name);
    }

    @Override
    public void addFournisseurToProduct(String immatriculation, String productName) {
        Produit produit = produitRepository.findByProductName(productName);
        if (produit == null) throw new RuntimeException("produit inexistant : imopossible de faire l'ajout");

        Fournisseur fournisseur = fournisseurRepository.getByImmatriculation(immatriculation);
        if (fournisseur == null) throw new RuntimeException("fournisseur inexistant : imopossible de faire l'ajout");

        fournisseur.getProduits().add(produit);

        produitRepository.save(produit);
    }

    @Override
    public ProduitResponseDTO createProduct2(ProduitDTO produit) {
        return null;
    }

    @Override
    public List<ProduitResponseDTO> getProductByType(String type) {
        List<Produit> produits  = produitRepository.getProductByType(type);
        if (produits.isEmpty()) throw new RuntimeException("aucun produit trouvé pour ce type "+type);

        List<ProduitResponseDTO> responseDTOS = new ArrayList<>();
        for (Produit p : produits){
            responseDTOS.add(produitResponseDTO.toProductResponse(p));
        }
        return responseDTOS;
    }

    @Override
    public List<ProduitResponseDTO> getProductsByFournisseurName(String nameFour) {
        return List.of();
    }

    @Override
    public List<ProduitResponseDTO> getProductCommand() {
        return  new ArrayList<>(produitRepository.getProductCommand().stream().map(produit -> produitResponseDTO.toProductResponse(produit)).toList());
    }
}
