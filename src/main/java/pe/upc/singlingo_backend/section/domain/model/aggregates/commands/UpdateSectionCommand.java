package pe.upc.singlingo_backend.section.domain.model.aggregates.commands;

import jakarta.validation.constraints.NotBlank;

public record UpdateSectionCommand(
        @NotBlank long id,
        @NotBlank String sectionName,
        @NotBlank String description
) {

}