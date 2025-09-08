package com.labo.gestion_stock.controllers;

import com.labo.gestion_stock.entities.Cathegory;
import com.labo.gestion_stock.services.categorieService.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/category")
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @PostMapping("/create")
    public ResponseEntity<Cathegory> create(@RequestBody Cathegory cathegory){
        Cathegory cathegory1 = categoryService.createCategory(cathegory);
        return ResponseEntity.ok(cathegory1);
    }

    @GetMapping("/")
    public ResponseEntity<List<Cathegory>> getAll(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
}
