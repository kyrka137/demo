package com.demo.db;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Jelzi a Springnek, hogy ez egy REST API végpont
@RequestMapping("/api/users") // A bázis URL (mint C#-ban a [Route("api/[controller]")])
public class UserController {

    private final UserRepository userRepository;

    // Dependency Injection konstruktoron keresztül
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET HTTP kérés: Visszaadja az összes usert (Böngészőből is működik!)
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Automatikus SELECT * FROM users
    }

    // POST HTTP kérés: Új usert hoz létre (JSON-ből várja az adatokat)
    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser); // Automatikus INSERT INTO
    }
}