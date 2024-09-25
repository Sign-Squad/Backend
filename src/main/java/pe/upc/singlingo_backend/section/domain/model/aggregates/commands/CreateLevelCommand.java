package pe.upc.singlingo_backend.section.domain.model.aggregates.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateLevelCommand (
    @NotBlank String levelName,
    @NotBlank String description,
    @NotBlank int totalQuestions,
    @NotBlank int SectionID
) {

}