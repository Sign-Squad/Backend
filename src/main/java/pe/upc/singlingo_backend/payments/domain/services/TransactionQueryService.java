package pe.upc.singlingo_backend.payments.domain.services;

import pe.upc.singlingo_backend.payments.domain.model.aggregates.Transaction;
import pe.upc.singlingo_backend.payments.domain.model.queries.GetAllTransactionByUserIDQuery;
import pe.upc.singlingo_backend.payments.domain.model.queries.GetAllTransactionsQuery;
import pe.upc.singlingo_backend.payments.domain.model.queries.GetTransactionByIDQuery;

import java.util.List;
import java.util.Optional;

public interface TransactionQueryService {
    Optional<Transaction> handle(GetTransactionByIDQuery query);
    List<Transaction> handle(GetAllTransactionsQuery query);
    List<Transaction> handle(GetAllTransactionByUserIDQuery query);
}
