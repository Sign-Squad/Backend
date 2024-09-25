package pe.upc.singlingo_backend.section.domain.services;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Question;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.*;

import java.util.Optional;

public interface QuestionCommandService {
    Optional<Question> handle(CreateQuestionCommand command);
    Optional<Question> handle(UpdateQuestionCommand command);
    void deleteQuestion(DeleteQuestionCommand command);
}
