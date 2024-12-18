package MarvelAPIFree.MarvelBackend.services;

import MarvelAPIFree.MarvelBackend.dtos.CharacterRequestDTO;
import MarvelAPIFree.MarvelBackend.dtos.CharacterResponseDTO;
import MarvelAPIFree.MarvelBackend.models.MarvelCharacter;
import MarvelAPIFree.MarvelBackend.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public CharacterResponseDTO createCharacter(CharacterRequestDTO characterRequestDTO) {
        Optional<MarvelCharacter> existCharacter = characterRepository.findById(characterRequestDTO.id());
        if (existCharacter.isPresent())
            throw new CharacterExistingIdException("Character already exist with this ID");

        MarvelCharacter marvelCharacter = CharacterMapper.toEntity(characterRequestDTO);
        MarvelCharacter savedMarvelCharacter = characterRepository.save(marvelCharacter);
        return CharacterMapper.toResponseDTO(savedMarvelCharacter);
    }
}
