package pe.upc.singlingo_backend.section.interfaces.rest.resources;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Option;

import java.util.List;

public record QuestionResource (
        long id,
        String questionType,
        String title,
        List<Option> options,
        Option correctAnswer,
        int levelID
){
}
