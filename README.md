# 🚀 User Management System (Spring Boot)

Ez a projekt egy modern, rétegelt architektúrájú (Controller-Service-Repository) Java webalkalmazás, amely a felhasználók adatainak kezelését végzi. A projekt célja a tiszta kód, a robusztus backend integrációk és a független tesztelési elvek bemutatása.

## 🛠️ Használt Technológiák

* **Backend:** Java 17, Spring Boot 4.0.3
* **Adatbázis (Éles):** PostgreSQL (Docker konténerben futtatva)
* **Adatbázis (Teszt):** H2 In-Memory Database (CI/CD barát, elszigetelt teszteléshez)
* **ORM:** Spring Data JPA / Hibernate
* **Frontend:** Jakarta Server Pages (JSP), HTML/CSS (Bootstrap 5 dizájnnal)
* **API Dokumentáció:** Swagger UI / OpenAPI 3
* **Build Eszköz:** Maven

## 🏗️ Architektúra és Felelősségi Körök

Az alkalmazás a klasszikus MVC és REST elveket követi:

1. **WebController:** A JSP alapú vizuális frontend kiszolgálása.
2. **UserController:** A REST API végpontok biztosítása külső kliensek (pl. React/Angular frontend vagy mobilalkalmazás) számára.
3. **UserRepository:** Adatbázis-műveletek transzparens kezelése a Spring Data JPA segítségével.

## 🚀 Futtatás Lokálisan (Fejlesztői környezet)

### 1. Előfeltételek

A projekt futtatásához szükséges a **Java 17+**, a **Maven**, valamint a **Docker** telepítése.

### 2. Adatbázis indítása

A fejlesztéshez egy helyi PostgreSQL adatbázisra van szükség, amelyet a leggyorsabban Docker segítségével húzhatsz fel:

```bash
docker run --name pg-interju -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=jelszo -e POSTGRES_DB=sajat_adatbazis -p 5432:5432 -d postgres
```
