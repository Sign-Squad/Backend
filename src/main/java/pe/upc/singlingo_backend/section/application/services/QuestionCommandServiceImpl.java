package pe.upc.singlingo_backend.section.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Question;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateQuestionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.DeleteQuestionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.UpdateQuestionCommand;
import pe.upc.singlingo_backend.section.domain.services.QuestionCommandService;
import pe.upc.singlingo_backend.section.infraestructure.persistence.jpa.QuestionRepository;

import java.util.Optional;
@Service
public class QuestionCommandServiceImpl implements QuestionCommandService {
    private final QuestionRepository questionRepository;

    public QuestionCommandServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Question> handle(CreateQuestionCommand command) {
        var question = new Question(command);
        questionRepository.save(question);
        return Optional.of(question);
    }

    @Override
    public Optional<Question> handle(UpdateQuestionCommand command) {
        var auxQuestion = questionRepository.findById(command.id());
        if (auxQuestion.isPresent()) {
            Question question = auxQuestion.get();
            question.setQuestionType(command.questionType());
            question.setTitle(command.title());
            question.setContent(command.content());
            question.setCorrectAnswer(command.correctAnswer());
            question.setLevelID(command.levelID());
            questionRepository.save(question);
            return Optional.of(question);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteQuestion(DeleteQuestionCommand command) {
        questionRepository.deleteById(command.id());
    }
}
