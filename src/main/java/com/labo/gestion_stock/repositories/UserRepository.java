package com.labo.gestion_stock.repositories;

import com.labo.gestion_stock.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByNameUser(String nameUser);

    User findUserByNameUserAndPassword(String nameUser, String password);

    @Query("SELECT u.email FROM User u where u.nameUser = :nameUser")
    String getEmail(@Param("nameUser") String nameUser);

    @Query("SELECT u FROM User u where u.nameUser = :name")
    User getUser(@Param("name") String name);
}
