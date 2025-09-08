package com.labo.gestion_stock.services.fournisseurService;

import com.labo.gestion_stock.dtoEntity.fournisseurDTO.FournisseurDTO;
import com.labo.gestion_stock.dtoEntity.fournisseurDTO.FournisseurResponseDTO;
import com.labo.gestion_stock.entities.Fournisseur;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FournisseurService {
    FournisseurResponseDTO createFournisseur(FournisseurDTO fournisseur);
    List<FournisseurResponseDTO> getAllFournisseur();
    void deleteById(long id);
    FournisseurResponseDTO updateFounisseur(long id,FournisseurDTO fournisseurDTO);
    boolean existById(long id);
    Fournisseur findFournisseurByImmatriculation(String immatriculation);


    List<Fournisseur> getFournisseurByType(String type);

    List<Fournisseur> getFounisseurNotFour();

    long countFournisseurFour();

    long getQuantityOfProductByFour(String name);
}
