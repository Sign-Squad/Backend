package pe.upc.singlingo_backend.section.domain.services;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Question;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetQuestionByIDQuery;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetQuestionsByLevelIDQuery;

import java.util.List;
import java.util.Optional;

public interface QuestionQueryService {
    Optional<Question> handle(GetQuestionByIDQuery query);
    List<Question> handle(GetQuestionsByLevelIDQuery query);
}
