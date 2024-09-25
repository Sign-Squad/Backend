package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateQuestionCommand;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.CreateQuestionResource;

public class CreateQuestionCommandFromResourceAssembler {
    public static CreateQuestionCommand toCommandResource(CreateQuestionResource resource) {
        return new CreateQuestionCommand(resource.questionType(),resource.title(),resource.options(), resource.correctAnswer(),resource.levelID());
    }
}
