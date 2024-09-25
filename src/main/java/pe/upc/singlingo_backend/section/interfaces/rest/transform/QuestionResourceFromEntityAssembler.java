package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Question;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.QuestionResource;

public class QuestionResourceFromEntityAssembler {
    public static QuestionResource toResourceFromEntity(Question entity) {
        return new QuestionResource(entity.getId(),entity.getQuestionType(),entity.getTitle(),entity.getOptions(), entity.getCorrectAnswer(),entity.getLevelID());
    }
}
