package pe.upc.singlingo_backend.section.domain.model.aggregates.commands;

import jakarta.validation.constraints.NotBlank;

public record UpdateQuestionCommand(
        @NotBlank long id,
        @NotBlank String questionType,
        @NotBlank String title,
        @NotBlank String correctAnswer,
        @NotBlank int levelID
) {

}