package com.demo.db;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Konstruktor injektálás (Ugyanúgy, mint C#-ban!)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createNewUser() {
        User newUser = new User();
        newUser.setName("Teszt Elek");
        newUser.setEmail("teszt@elek.hu");
        
        // Mentés az adatbázisba egyetlen sorral:
        userRepository.save(newUser); 
    }
}