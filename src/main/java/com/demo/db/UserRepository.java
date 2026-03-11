package com.demo.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


// A JpaRepository várja az Entitás típusát (User) és az Id típusát (Long)
public interface UserRepository extends JpaRepository<User, Long> {
    
    // A sima CRUD (Save, FindById, Delete) már eleve benne van!
    
    // Ha egyedi keresés kell, csak elnevezed a metódust a megfelelő konvenció szerint, 
    // és a Spring megírja mögé az SQL-t (SELECT * FROM users WHERE email = ?)
    User findByEmail(String email);

    List<User> findByEmailContainingIgnoreCase(String emailFragment);
}