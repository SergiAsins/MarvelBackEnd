package MarvelAPIFree.MarvelBackend.controllers;

import MarvelAPIFree.MarvelBackend.models.MarvelCharacter;
import MarvelAPIFree.MarvelBackend.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .andExpect(content().string("The character has been deleted"));
    }
}