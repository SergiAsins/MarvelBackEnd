package MarvelAPIFree.MarvelBackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Objects;

@Entity
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


    // Default constructor
    public MarvelCharacter() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    // Constructor with all parameters
    public MarvelCharacter(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}




