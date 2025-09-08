package com.labo.gestion_stock.services.categorieService;

import com.labo.gestion_stock.entities.Cathegory;
import com.labo.gestion_stock.repositories.CategoriRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoriRepository categoriRepository;

    public CategoryServiceImpl(CategoriRepository categoriRepository){
        this.categoriRepository = categoriRepository;
    }
    @Override
    public Cathegory createCategory(Cathegory cathegory) {
        Cathegory cathegory1 = categoriRepository.save(cathegory);
        return cathegory1;
    }

    @Override
    public List<Cathegory> getAllCategory() {
        return categoriRepository.findAll();
    }

    @Override
    public Cathegory findByType(String type) {
        return categoriRepository.findByType(type);
    }
}
