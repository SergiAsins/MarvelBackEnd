package MarvelAPIFree.MarvelBackend.dtos;

import jakarta.validation.constraints.*;

import org.antlr.v4.runtime.misc.NotNull;

public record CharacterRequestDTO (
        //@NotNull(message = "The name cannot be null")
        @NotEmpty(message = "The name cannot be empty")
        String name,

        String description

        //there is not in our example
){}