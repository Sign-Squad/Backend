package pe.upc.singlingo_backend.payments.domain.services;

import pe.upc.singlingo_backend.payments.domain.model.aggregates.Transaction;
import pe.upc.singlingo_backend.payments.domain.model.commands.CreateTransactionCommand;
import pe.upc.singlingo_backend.payments.domain.model.commands.DeleteTransactionCommand;

import java.util.Optional;

public interface TransactionCommandService {
    Optional<Transaction> handle(CreateTransactionCommand command);
    void deleteTransaction(DeleteTransactionCommand command);
}
