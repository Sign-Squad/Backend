package pe.upc.singlingo_backend.payments.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.singlingo_backend.payments.domain.model.aggregates.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllTransactionsByUserID(Long userID);
}
