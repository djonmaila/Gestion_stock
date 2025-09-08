package com.labo.gestion_stock.repositories;

import com.labo.gestion_stock.entities.Cathegory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriRepository extends JpaRepository<Cathegory,Long> {
    Cathegory findByType(String type);
}
