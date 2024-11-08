package pe.upc.singlingo_backend.payments.domain.model.commands;

import jakarta.validation.constraints.NotBlank;
import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;

public record CreateTransactionCommand(
        @NotBlank double amount,
        @NotBlank String date ,
        @NotBlank String transactionType,
        @NotBlank Users userID
) {
}
