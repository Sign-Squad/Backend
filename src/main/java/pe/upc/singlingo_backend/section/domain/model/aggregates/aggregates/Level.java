package pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateLevelCommand;
import pe.upc.singlingo_backend.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "level")
@Getter
@Setter
@NoArgsConstructor
public class Level extends AuditableAbstractAggregateRoot<Level> {
    private String levelName;
    private String description;
    private int totalQuestions;
    private int sectionID;

    public Level(CreateLevelCommand command){
        this.levelName = command.levelName();
        this.description = command.description();
        this.totalQuestions = command.totalQuestions();
        this.sectionID = command.SectionID();
    }


}
