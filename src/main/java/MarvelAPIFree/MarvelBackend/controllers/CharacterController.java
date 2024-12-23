package MarvelAPIFree.MarvelBackend.controllers;

import MarvelAPIFree.MarvelBackend.dtos.CharacterRequestDTO;
import MarvelAPIFree.MarvelBackend.dtos.CharacterResponseDTO;
import MarvelAPIFree.MarvelBackend.services.CharacterService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvelcharacters")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<CharacterResponseDTO> addCharacter(@RequestBody @Valid CharacterRequestDTO characterRequestDTO){
        CharacterResponseDTO characterResponseDTO = characterService.createCharacter(characterRequestDTO);
        return new ResponseEntity<>(characterResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterResponseDTO> getGuardianById(@PathVariable Long id) {
        CharacterResponseDTO guardianResponseDTO = characterService.findById(id);
        return new ResponseEntity<>(guardianResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    public List<CharacterResponseDTO> getGuardianByName(@PathParam("name") String name) {
        if (name == null) {
            return characterService.findAll();
        }
        return characterService.findByNameIgnoreCaseContaining(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterResponseDTO> updateGuardian(@PathVariable Long id, @RequestBody @Valid CharacterRequestDTO characterRequestDTO) {
        CharacterResponseDTO guardianResponseDTO = characterService.updateGuardianById(id, characterRequestDTO);
        return new ResponseEntity<>(guardianResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuardian(@PathVariable Long id) {
        characterService.deleteCharacterById(id);
        return new ResponseEntity<>("The character has been eliminated", HttpStatus.OK);
    }
}



