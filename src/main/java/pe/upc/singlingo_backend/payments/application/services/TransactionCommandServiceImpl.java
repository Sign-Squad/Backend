package pe.upc.singlingo_backend.payments.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.payments.domain.model.aggregates.Transaction;
import pe.upc.singlingo_backend.payments.domain.model.commands.CreateTransactionCommand;
import pe.upc.singlingo_backend.payments.domain.model.commands.DeleteTransactionCommand;
import pe.upc.singlingo_backend.payments.domain.services.TransactionCommandService;
import pe.upc.singlingo_backend.payments.infraestructure.persistence.TransactionRepository;

import java.util.Optional;
@Service
public class TransactionCommandServiceImpl implements TransactionCommandService {
    private final TransactionRepository transactionRepository;

    public TransactionCommandServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<Transaction> handle(CreateTransactionCommand command) {
        var transaction = new Transaction(command);
        transactionRepository.save(transaction);
        return Optional.of(transaction);
    }

    @Override
    public void deleteTransaction(DeleteTransactionCommand command) {
        transactionRepository.deleteById(command.id());
    }
}
