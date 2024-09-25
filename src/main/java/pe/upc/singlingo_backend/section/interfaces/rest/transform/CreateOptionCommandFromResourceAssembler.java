package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateOptionCommand;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.CreateOptionResource;

public class CreateOptionCommandFromResourceAssembler {
    public static CreateOptionCommand toCommandResource(CreateOptionResource resource) {
        return new CreateOptionCommand(resource.textContent(),resource.imageUrl());
    }
}
