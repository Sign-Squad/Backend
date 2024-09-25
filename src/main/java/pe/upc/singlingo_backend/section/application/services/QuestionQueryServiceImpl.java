package pe.upc.singlingo_backend.section.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Question;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetQuestionByIDQuery;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetQuestionsByLevelIDQuery;
import pe.upc.singlingo_backend.section.domain.services.QuestionQueryService;
import pe.upc.singlingo_backend.section.infraestructure.persistence.jpa.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionQueryServiceImpl implements QuestionQueryService {
    private final QuestionRepository questionRepository;

    public QuestionQueryServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Question> handle(GetQuestionByIDQuery query) {
        return questionRepository.findById(query.id());
    }

    @Override
    public List<Question> handle(GetQuestionsByLevelIDQuery query) {
        return questionRepository.findQuestionsByLevelID(query.levelID());
    }
}
