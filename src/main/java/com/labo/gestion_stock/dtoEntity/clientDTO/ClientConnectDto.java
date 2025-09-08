package com.labo.gestion_stock.dtoEntity.clientDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClientConnectDto {
    private String userName;
    private String password;
}
