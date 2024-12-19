package MarvelAPIFree.MarvelBackend.controllers;

import MarvelAPIFree.MarvelBackend.models.MarvelCharacter;
import MarvelAPIFree.MarvelBackend.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.h2.index.IndexCondition.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
class CharacterControllerTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterController characterController;

    @Autowired
    MockMvc mockMvc;

    @Test
    void givenSavedCharacter_whenCallDeleteById_thenTheCharacterIsErased() throws Exception{
        MarvelCharacter marvelCharacter = new MarvelCharacter("Wilson", "knows a lot about geology");
        characterRepository.save(marvelCharacter);

        mockMvc.perform(delete("/marvelcharacters/" + marvelCharacter.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string("The character has been eliminated"));
    }

    @Test
    void givenNewCharacter_whenCallSave_thenCharacterIsSaved() throws Exception {
        MarvelCharacter marvelCharacter = new MarvelCharacter("Harry", "can pee so far");

        mockMvc.perform(post("/marvelcharacters")
                        .contentType("application/json")
                        .content("{\"name\":\"Harry\", \"description\":\"can pee so far\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Harry\",\"description\":\"can pee so far\"}"));
    }

    @Test
    void givenExistingCharacter_whenUpdateCharacter_thenCharacterIsUpdated() throws Exception {
        MarvelCharacter marvelCharacter = new MarvelCharacter("Natasha", "is a spy");
        marvelCharacter = characterRepository.save(marvelCharacter);

        mockMvc.perform(put("/marvelcharacters/" + marvelCharacter.getId())
                        .contentType("application/json")
                        .content("{\"name\":\"Natasha\", \"description\":\"is a super spy\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Natasha\",\"description\":\"is a super spy\"}"));
    }
}