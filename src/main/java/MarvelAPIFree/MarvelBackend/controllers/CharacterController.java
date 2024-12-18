package MarvelAPIFree.MarvelBackend.controllers;

import MarvelAPIFree.MarvelBackend.services.CharacterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MarvelCharacter")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }
}
