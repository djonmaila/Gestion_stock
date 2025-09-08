package com.labo.gestion_stock.services.productCommandeService;

import com.labo.gestion_stock.dtoEntity.productCommandeDTO.ProductCommandeDTO;
import com.labo.gestion_stock.entities.ProductCommande;

public interface ProductServiceCommande {
    ProductCommande create(ProductCommandeDTO dto);
}
