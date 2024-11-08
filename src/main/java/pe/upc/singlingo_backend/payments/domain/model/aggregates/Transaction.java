package pe.upc.singlingo_backend.payments.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.upc.singlingo_backend.payments.domain.model.commands.CreateTransactionCommand;
import pe.upc.singlingo_backend.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
public class Transaction extends AuditableAbstractAggregateRoot<Transaction> {

    private double amount;

    private String date;

    private String transactionType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userID;

    public Transaction(CreateTransactionCommand command){
        this.amount = command.amount();
        this.date = command.date();
        this.transactionType = command.transactionType();
        this.userID = command.userID();
    }

}
