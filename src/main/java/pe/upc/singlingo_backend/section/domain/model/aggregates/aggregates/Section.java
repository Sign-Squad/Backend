package pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateSectionCommand;
import pe.upc.singlingo_backend.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "section")
@Getter
@Setter
@NoArgsConstructor
public class Section extends AuditableAbstractAggregateRoot<Section> {
    private String sectionName;
    private String description;

    public Section(CreateSectionCommand command) {
        this.sectionName = command.sectionName();
        this.description = command.description();
    }
}
