package com.labo.gestion_stock.services.categorieService;

import com.labo.gestion_stock.entities.Cathegory;

import java.util.List;

public interface CategoryService {
    Cathegory createCategory(Cathegory cathegory);
    List<Cathegory> getAllCategory();
    Cathegory findByType(String type);
}
