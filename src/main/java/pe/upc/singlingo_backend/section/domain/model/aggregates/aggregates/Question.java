package pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateQuestionCommand;
import pe.upc.singlingo_backend.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
public class Question extends AuditableAbstractAggregateRoot<Question> {
    private String questionType;
    private String title;
    private List<Option> options;
    private Option correctAnswer;
    private int levelID;

    public Question(CreateQuestionCommand command){
        this.questionType = command.questionType();
        this.title = command.title();
        this.options = command.options();
        this.correctAnswer = command.correctAnswer();
        this.levelID = command.levelID();
    }
}
