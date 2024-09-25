package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateLevelCommand;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.CreateLevelResource;

public class CreateLevelCommandFromResourceAssembler {
    public static CreateLevelCommand toCommandResource(CreateLevelResource resource) {
        return new CreateLevelCommand(resource.levelName(),resource.description(),resource.totalQuestions(),resource.SectionID());
    }
}
