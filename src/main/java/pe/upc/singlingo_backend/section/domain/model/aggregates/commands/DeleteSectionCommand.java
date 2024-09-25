package pe.upc.singlingo_backend.section.domain.model.aggregates.commands;

import jakarta.validation.constraints.NotBlank;

public record DeleteSectionCommand(
    @NotBlank long id
) {

}