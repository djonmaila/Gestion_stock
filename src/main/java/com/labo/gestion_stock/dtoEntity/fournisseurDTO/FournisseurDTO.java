package com.labo.gestion_stock.dtoEntity.fournisseurDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FournisseurDTO {
    private String nameUser;
    private String email;
    private String numTel;
    private String immatriculation;
    private String password;
    private String referrence;
    private String role;
}
