package com.labo.gestion_stock.services.fournisseurService;

import com.labo.gestion_stock.dtoEntity.fournisseurDTO.FournisseurDTO;
import com.labo.gestion_stock.dtoEntity.fournisseurDTO.FournisseurResponseDTO;
import com.labo.gestion_stock.entities.Fournisseur;
import com.labo.gestion_stock.entities.Produit;
import com.labo.gestion_stock.repositories.FournisseurRepository;
import com.labo.gestion_stock.repositories.UserRepository;
import com.labo.gestion_stock.services.produitService.ProduitService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {

    private UserRepository userRepository;
    private FournisseurRepository fournisseurRepository;
    private ProduitService produitService;
    private ModelMapper modelMapper;


    @Override
    public FournisseurResponseDTO createFournisseur(FournisseurDTO fournisseur) {
        Fournisseur newFournisseur = modelMapper.map(fournisseur,Fournisseur.class);
        Fournisseur four =userRepository.save(newFournisseur);

        return new FournisseurResponseDTO(
                four.getId_user(),
                four.getNameUser(),
                four.getEmail(),
                four.getNumTel(),
                four.getRole().name()
        );
    }

    @Override
    public List<FournisseurResponseDTO> getAllFournisseur() {
        List<FournisseurResponseDTO> fournisseurResponseDTOS = new ArrayList<>();
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();

        for (Fournisseur four : fournisseurs){
            fournisseurResponseDTOS.add(
                    new FournisseurResponseDTO(
                            four.getId_user(),
                            four.getNameUser(),
                            four.getEmail(),
                            four.getNumTel(),
                            four.getRole().name()
                    )
            );
        }

        return fournisseurResponseDTOS;
    }

    @Override
    public void deleteById(long id) {
        Fournisseur fournisseur = (Fournisseur) userRepository.findById(id).orElse(null);
        if (fournisseur == null) throw new RuntimeException("fournisseur inexistant");
        List<Produit> produits = fournisseur.getProduits();
        for (Produit p : produits){
            p.getFournisseurs().remove(fournisseur);
        }
        userRepository.deleteById(id);
    }

    @Override
    public FournisseurResponseDTO updateFounisseur(long id, FournisseurDTO fournisseurDTO) {
        Fournisseur four = fournisseurRepository.findById(id).orElse(null);
        if (four == null){
            throw new RuntimeException("erreur de mise à jour : fournisseur inexistant");
        }
        four.setNameUser(fournisseurDTO.getNameUser());
        four.setEmail(fournisseurDTO.getEmail());
        four.setPassword(fournisseurDTO.getPassword());
        four.setNumTel(fournisseurDTO.getNumTel());
        four.setImmatriculation(fournisseurDTO.getImmatriculation());
        four.setReferrence(fournisseurDTO.getReferrence());

        Fournisseur fournisseur = fournisseurRepository.save(four);
        return new FournisseurResponseDTO(
                fournisseur.getId_user(),
                fournisseur.getNameUser(),
                fournisseur.getEmail(),
                fournisseur.getNumTel(),
                fournisseur.getRole().name()
        );
    }

    @Override
    public boolean existById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Fournisseur findFournisseurByImmatriculation(String immatriculation) {
        return fournisseurRepository.getByImmatriculation(immatriculation);
    }


    @Override
    public List<Fournisseur> getFournisseurByType(String type) {
        return fournisseurRepository.getFournisseurByType(type);
    }

    @Override
    public List<Fournisseur> getFounisseurNotFour() {
        return fournisseurRepository.getFounisseurNotFour();
    }

    @Override
    public long countFournisseurFour() {
        return fournisseurRepository.countFournisseurFour();
    }

    @Override
    public long getQuantityOfProductByFour(String name) {
        return fournisseurRepository.getQuantityOfProductByFour(name);
    }
}
