package pe.upc.singlingo_backend.payments.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record DeleteTransactionCommand(
        @NotBlank long id
)  {
}
