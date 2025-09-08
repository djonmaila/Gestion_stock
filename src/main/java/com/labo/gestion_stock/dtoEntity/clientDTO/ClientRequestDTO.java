package com.labo.gestion_stock.dtoEntity.clientDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientRequestDTO {
    private String nameUser;
    private String email;
    private String numTel;
    private String password;
    private String matricule;
    private String role;
}
