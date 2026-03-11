package com.demo.db;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldFindUserByEmailFragment() {
        // 1. Felkészülés (Arrange): Létrehozunk és elmentünk egy teszt usert
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@company.com");
        userRepository.save(user);

        // 2. Cselekvés (Act): Megpróbáljuk megkeresni egy email töredékkel
        List<User> foundUsers = userRepository.findByEmailContainingIgnoreCase("DOE@COMPANY");

        // 3. Ellenőrzés (Assert): Megnézzük, hogy tényleg megtalálta-e
        assertEquals(1, foundUsers.size());
        assertEquals("John Doe", foundUsers.get(0).getName());
    }
}