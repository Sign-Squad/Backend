package pe.upc.singlingo_backend.payments.interfaces.rest.resources;

import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;

public record CreateTransactionResource(
         double amount,
         String date ,
         String transactionType,
         Long userID
) {
}
