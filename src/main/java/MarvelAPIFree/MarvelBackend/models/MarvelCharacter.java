package MarvelAPIFree.MarvelBackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class MarvelCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;

    public MarvelCharacter(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public MarvelCharacter(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarvelCharacter marvelCharacter = (MarvelCharacter) o;
        return Objects.equals(id, marvelCharacter.id) && Objects.equals(name, marvelCharacter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description ='" + description + '\'' +
                '}';
    }
}


