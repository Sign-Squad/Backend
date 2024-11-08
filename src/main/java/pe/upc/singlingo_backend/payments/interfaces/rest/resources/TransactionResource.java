package pe.upc.singlingo_backend.payments.interfaces.rest.resources;

import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;

public record TransactionResource(
        long id,
        double amount,
        String date ,
        String transactionType,
        Users userID
) {
}
