package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateSectionCommand;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.CreateSectionResource;

public class CreateSectionCommandFromResourceAssembler {
    public static CreateSectionCommand toCommandResource(CreateSectionResource resource) {
        return new CreateSectionCommand(resource.sectionName(),resource.description());
    }
}
