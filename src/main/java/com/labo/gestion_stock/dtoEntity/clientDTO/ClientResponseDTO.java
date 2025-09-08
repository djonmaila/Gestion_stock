package com.labo.gestion_stock.dtoEntity.clientDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClientResponseDTO {
    private long id;
    private String nameUser;
    private String email;
    private String numTel;
    private String matricule;
}
