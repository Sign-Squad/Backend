package pe.upc.singlingo_backend.section.domain.model.aggregates.commands;

import jakarta.validation.constraints.NotBlank;

public record UpdateOptionCommand(
        @NotBlank long id,
        @NotBlank String textContent,
        @NotBlank String imageUrl
) {

}