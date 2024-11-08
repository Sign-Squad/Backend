package pe.upc.singlingo_backend.payments.interfaces.rest.transform;

import pe.upc.singlingo_backend.payments.domain.model.commands.CreateTransactionCommand;
import pe.upc.singlingo_backend.payments.interfaces.rest.resources.CreateTransactionResource;

public class CreateTransactionCommandFromResourceAssembler {
    public static CreateTransactionCommand toCommandResource(CreateTransactionResource resource) {
        return new CreateTransactionCommand(resource.amount(), resource.date(),resource.transactionType(),resource.userID());
    }
}
