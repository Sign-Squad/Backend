package pe.upc.singlingo_backend.section.domain.model.aggregates.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateLevelCompleteCommand(
        @NotNull long id,
        @NotBlank boolean levelComplete
) {
}
