package pe.upc.singlingo_backend.users.domain.model.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateLivesCommand(
        @NotNull Long id,
         int lives
) {

}
