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
    private String iconUrl;
    private int position;
    private int totalQuestions;
    private int sectionID;
    private boolean levelComplete;

    public Level(CreateLevelCommand command){
        this.levelName = command.levelName();
        this.iconUrl = command.iconUrl();
        this.position = command.position();
        this.totalQuestions = command.totalQuestions();
        this.sectionID = command.SectionID();
        this.levelComplete = command.levelComplete();
    }


}
