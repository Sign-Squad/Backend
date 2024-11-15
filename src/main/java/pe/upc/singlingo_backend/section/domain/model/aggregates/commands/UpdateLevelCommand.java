package pe.upc.singlingo_backend.section.domain.model.aggregates.commands;

import jakarta.validation.constraints.NotBlank;

public record UpdateLevelCommand(
        @NotBlank long id,
        @NotBlank String levelName,
        @NotBlank String iconUrl,
        @NotBlank int position,
        @NotBlank int totalQuestions,
        @NotBlank int SectionID,
        @NotBlank boolean levelComplete
) {

}