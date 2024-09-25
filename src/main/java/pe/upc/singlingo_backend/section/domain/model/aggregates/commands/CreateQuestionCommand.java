package pe.upc.singlingo_backend.section.domain.model.aggregates.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateQuestionCommand(
        @NotBlank String questionType,
        @NotBlank String title,
        @NotBlank String correctAnswer,
        @NotBlank int levelID
) {
}
