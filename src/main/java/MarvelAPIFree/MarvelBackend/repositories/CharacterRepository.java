package MarvelAPIFree.MarvelBackend.repositories;

import MarvelAPIFree.MarvelBackend.models.MarvelCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<MarvelCharacter, Long> {

    Optional<MarvelCharacter> findById(Long id);

    List<MarvelCharacter> findByNameIgnoreCaseContaining(String name);


}
