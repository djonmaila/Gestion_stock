package com.labo.gestion_stock.dtoEntity.productCommandeDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCommandeDTO {
    private int qteCommande;
    private String numCom;
    private String productName;
}
