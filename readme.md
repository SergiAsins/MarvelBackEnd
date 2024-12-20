# 🦸‍♂️  **Marvel Backend API**

This project is a Spring Boot API that provides endpoints to retrieve information about Marvel characters. The API is designed with simplicity, following best practices.

---

## 🦹⚡️️ **Project Structure**

```plaintext
MarvelBackend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── MarvelAPIFree/
│   │   │       └── MarvelBackend/
│   │   │           ├── controllers/
│   │   │           │   └── CharacterController.java
│   │   │           ├── models/
│   │   │           │   └── MarvelCharacter.java
│   │   │           └── services/
│   │   │               └── CharacterService.java
│   │   │           └── respositories/
│   │   │               └── CharacterRepository.java
│   │   │           └── dtos/
│   │   │               └── CharacterRequestDTP.jaba
│   │   │               └── CharacterResponseDTP.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── MarvelAPIFree/
│               └── MarvelBackend/
│                   └── controllers/
│                       └── CharacterControllerTest.java
├── pom.xml
└── README.md