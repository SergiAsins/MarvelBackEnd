package MarvelAPIFree.MarvelBackend.mappers;

import MarvelAPIFree.MarvelBackend.dtos.CharacterRequestDTO;
import MarvelAPIFree.MarvelBackend.dtos.CharacterResponseDTO;
import MarvelAPIFree.MarvelBackend.models.MarvelCharacter;

public class CharacterMapper {
    public static MarvelCharacter toEntity(CharacterRequestDTO characterRequestDTO){
        return new MarvelCharacter(
                characterRequestDTO.name(),
                characterRequestDTO.description());
    }

    public static CharacterResponseDTO toResponseDTO(MarvelCharacter marvelCharacter){
        return new CharacterResponseDTO(
                marvelCharacter.getId(),
                marvelCharacter.getName(),
                marvelCharacter.getDescription());
    }
}
