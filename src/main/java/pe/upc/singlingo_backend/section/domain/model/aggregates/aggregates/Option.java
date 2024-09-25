package pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateOptionCommand;
import pe.upc.singlingo_backend.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "options_table")
@Getter
@Setter
@NoArgsConstructor
public class Option extends AuditableAbstractAggregateRoot<Option> {
    private String textContent;
    private String imageUrl;

    public Option(CreateOptionCommand command) {
        this.textContent = command.textContent();
        this.imageUrl = command.imageUrl();
    }
}
