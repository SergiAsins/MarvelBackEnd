package MarvelAPIFree.MarvelBackend.services;

import MarvelAPIFree.MarvelBackend.dtos.CharacterRequestDTO;
import MarvelAPIFree.MarvelBackend.dtos.CharacterResponseDTO;
import MarvelAPIFree.MarvelBackend.exceptions.CharacterExistingIdException;
import MarvelAPIFree.MarvelBackend.exceptions.CharacterNotFoundException;
import MarvelAPIFree.MarvelBackend.mappers.CharacterMapper;
import MarvelAPIFree.MarvelBackend.models.MarvelCharacter;
import MarvelAPIFree.MarvelBackend.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public CharacterResponseDTO createCharacter(CharacterRequestDTO characterRequestDTO) {
            /*Optional<MarvelCharacter> existCharacter = characterRepository.findById(characterRequestDTO.id());
        if (existCharacter.isPresent())
            throw new CharacterExistingIdException("Character already exist with this ID");*/

        MarvelCharacter marvelCharacter = CharacterMapper.toEntity(characterRequestDTO);
        MarvelCharacter savedMarvelCharacter = characterRepository.save(marvelCharacter);
        return CharacterMapper.toResponseDTO(savedMarvelCharacter);
    }

    public List<CharacterResponseDTO> findAll(){
        List<MarvelCharacter> characterList = characterRepository.findAll();
        return characterList.stream()
                .map(CharacterMapper::toResponseDTO).toList();
    }

    public CharacterResponseDTO findById(Long id){
        Optional<MarvelCharacter> optionalCharacter = characterRepository.findById(id);

        if(optionalCharacter.isEmpty()){
            throw new CharacterNotFoundException("The character with id " + id + " does not exist.");
        }
        MarvelCharacter marvelCharacter = optionalCharacter.get();
        return CharacterMapper.toResponseDTO(marvelCharacter);
    }

    public List<CharacterResponseDTO> findByNameIgnoreCaseContaining(String name){
        List<MarvelCharacter> characters = characterRepository.findByNameIgnoreCaseContaining(name);

        if (characters.isEmpty()){
            throw new CharacterNotFoundException("The character with name " + name + " does not exist.");
        }
        return characters.stream()
                .map(CharacterMapper::toResponseDTO).toList();
    }

    public CharacterResponseDTO updateGuardianById(Long id, CharacterRequestDTO characterRequestDTO) {
        Optional<MarvelCharacter> optionalCharacter = characterRepository.findById(id);

        if(optionalCharacter.isPresent()) {
            MarvelCharacter marvelCharacter = optionalCharacter.get();

            marvelCharacter.setName(characterRequestDTO.name());
            marvelCharacter.setDescription(characterRequestDTO.description());


            MarvelCharacter updatedCharacter = characterRepository.save(marvelCharacter);
            return CharacterMapper.toResponseDTO(updatedCharacter);
        }
        throw new CharacterNotFoundException("The character with id " + id + " does not exist.");
    }

    public void deleteCharacterById(Long id) {
        Optional<MarvelCharacter> optionalCharacter = characterRepository.findById(id);

        if (optionalCharacter.isEmpty()) {
            throw new CharacterNotFoundException("The character with id " + id + " does not exist.");
        }
        characterRepository.deleteById(id);
    }
}
//}
