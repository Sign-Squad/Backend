package pe.upc.singlingo_backend.section.domain.model.aggregates.commands;

import jakarta.validation.constraints.NotBlank;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Option;

import java.util.List;

public record UpdateQuestionCommand(
        @NotBlank long id,
        @NotBlank String questionType,
        @NotBlank String title,
        @NotBlank List<Option> options,
        @NotBlank Option correctAnswer,
        @NotBlank int levelID
) {

}