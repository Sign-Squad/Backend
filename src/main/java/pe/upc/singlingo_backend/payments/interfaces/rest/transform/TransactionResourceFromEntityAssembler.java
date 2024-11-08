package pe.upc.singlingo_backend.payments.interfaces.rest.transform;

import pe.upc.singlingo_backend.payments.domain.model.aggregates.Transaction;
import pe.upc.singlingo_backend.payments.interfaces.rest.resources.TransactionResource;

public class TransactionResourceFromEntityAssembler {
    public static TransactionResource toResourceFromEntity(Transaction entity) {
        return new TransactionResource(entity.getId(), entity.getAmount(), entity.getDate(),
                entity.getTransactionType(), entity.getUserID());
    }
}
