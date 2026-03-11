package com.demo.db;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Ez jelzi, hogy weboldalakat fogunk visszaadni, nem JSON-t
public class WebController {

    private final UserRepository userRepository;

    public WebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users-page")
    public String showUsersPage(Model model) {
        // Lekérjük az adatokat a Postgresből, és betesszük a "users" nevű változóba
        model.addAttribute("users", userRepository.findAll());
        
        // Ez a string a fájl neve, amit a Spring keresni fog: users.jsp
        return "users"; 
    }
}
