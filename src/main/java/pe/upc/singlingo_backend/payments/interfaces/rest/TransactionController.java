package pe.upc.singlingo_backend.payments.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.singlingo_backend.payments.domain.model.commands.DeleteTransactionCommand;
import pe.upc.singlingo_backend.payments.domain.model.queries.GetAllTransactionByUserIDQuery;
import pe.upc.singlingo_backend.payments.domain.model.queries.GetAllTransactionsQuery;
import pe.upc.singlingo_backend.payments.domain.model.queries.GetTransactionByIDQuery;
import pe.upc.singlingo_backend.payments.domain.services.TransactionCommandService;
import pe.upc.singlingo_backend.payments.domain.services.TransactionQueryService;
import pe.upc.singlingo_backend.payments.interfaces.rest.resources.CreateTransactionResource;
import pe.upc.singlingo_backend.payments.interfaces.rest.resources.TransactionResource;
import pe.upc.singlingo_backend.payments.interfaces.rest.transform.CreateTransactionCommandFromResourceAssembler;
import pe.upc.singlingo_backend.payments.interfaces.rest.transform.TransactionResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Transaction", description = "Transactions management endpoints")
public class TransactionController {
    private final TransactionCommandService transactionCommandService;
    private final TransactionQueryService transactionQueryService;

    public TransactionController(TransactionCommandService transactionCommandService, TransactionQueryService transactionQueryService) {
        this.transactionCommandService = transactionCommandService;
        this.transactionQueryService = transactionQueryService;
    }

    @PostMapping
    public ResponseEntity<TransactionResource> createTransaction(@RequestBody CreateTransactionResource createTransactionResource) {
        var createTransactionCommand = CreateTransactionCommandFromResourceAssembler.toCommandResource(createTransactionResource);
        var transaction = transactionCommandService.handle(createTransactionCommand);
        if(transaction.isEmpty()) return ResponseEntity.badRequest().build();

        var transactionResource = TransactionResourceFromEntityAssembler.toResourceFromEntity(transaction.get());
        return ResponseEntity.ok(transactionResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        var deleteTransactionCommand = new DeleteTransactionCommand(id);
        transactionCommandService.deleteTransaction(deleteTransactionCommand);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<TransactionResource> getTransactionById(@PathVariable Long id) {
        var getTransactionByIdQuery = new GetTransactionByIDQuery(id);
        var transaction = transactionQueryService.handle(getTransactionByIdQuery);
        if(transaction.isEmpty()) return ResponseEntity.badRequest().build();
        var transactionResource = TransactionResourceFromEntityAssembler.toResourceFromEntity(transaction.get());
        return ResponseEntity.ok(transactionResource);
    }
    @GetMapping("/user/{userID}")
    public ResponseEntity<List<TransactionResource>> getTransactionsByUserID(@PathVariable Long userID) {
        var getTransactionByUserID = new GetAllTransactionByUserIDQuery(userID);
        var transactions = transactionQueryService.handle(getTransactionByUserID);
        if (transactions.isEmpty()) {return ResponseEntity.badRequest().build();}

        var transactionResource = transactions.stream()
                .map(TransactionResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(transactionResource);
    }
    @GetMapping()
    public ResponseEntity<List<TransactionResource>> getAllTransactions() {
        var getAllTransactionsQuery = new GetAllTransactionsQuery();
        var transactions = transactionQueryService.handle(getAllTransactionsQuery);
        if (transactions.isEmpty()) {return ResponseEntity.badRequest().build();}

        var transactionResource = transactions.stream()
                .map(TransactionResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(transactionResource);
    }
}
