package com.demo.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Jelzi, hogy ez egy adatbázis tábla
@Table(name = "users") // Opcionális: a tábla pontos neve
public class User {

    @Id // Ez a Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    private String name;
    private String email;

    // A Java-ban kellenek getterek és setterek (vagy Lombok könyvtár, ami legenerálja őket)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}