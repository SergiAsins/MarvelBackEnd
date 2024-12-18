package MarvelAPIFree.MarvelBackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Data
public class MarvelCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;

    public MarvelCharacter(@NotEmpty(message = "The name cannot be empty") String name, String description) {
    }
}


