package com.demo.db;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(UserController.class) // Csak a webes réteget indítja el, a teljes szervert nem
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc; // Ezzel tudunk "kamu" HTTP kéréseket küldeni

    @MockitoBean
    private UserRepository userRepository; // "Kamu" adatbázis kapcsolat

    @Test
    void shouldReturnAllUsers() throws Exception {
        // 1. Felkészülés (Arrange): Megmondjuk, mit adjon vissza a kamu adatbázis
        User mockUser = new User();
        mockUser.setName("Teszt Elek");
        mockUser.setEmail("teszt@elek.hu");
        Mockito.when(userRepository.findAll()).thenReturn(List.of(mockUser));

        // 2. Cselekvés és 3. Ellenőrzés (Act & Assert)
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk()) // Várjuk, hogy 200 OK legyen a válasz
                .andExpect(jsonPath("$[0].name").value("Teszt Elek")); // A JSON-ben benne kell lennie a névnek
    }
}
