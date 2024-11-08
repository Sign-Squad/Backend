package pe.upc.singlingo_backend.payments.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.payments.domain.model.aggregates.Transaction;
import pe.upc.singlingo_backend.payments.domain.model.queries.GetAllTransactionByUserIDQuery;
import pe.upc.singlingo_backend.payments.domain.model.queries.GetAllTransactionsQuery;
import pe.upc.singlingo_backend.payments.domain.model.queries.GetTransactionByIDQuery;
import pe.upc.singlingo_backend.payments.domain.services.TransactionQueryService;
import pe.upc.singlingo_backend.payments.infraestructure.persistence.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionQueryServiceImpl implements TransactionQueryService {
    private final TransactionRepository transactionRepository;

    public TransactionQueryServiceImpl(TransactionRepository repository, TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<Transaction> handle(GetTransactionByIDQuery query) {
        return  transactionRepository.findById(query.id());
    }

    @Override
    public List<Transaction> handle(GetAllTransactionsQuery query) {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> handle(GetAllTransactionByUserIDQuery query) {
        return transactionRepository.findAllTransactionsByUserID(query.userID());
    }
}
