package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Option;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.OptionResource;

public class OptionResourceFromEntityAssembler {
    public static OptionResource toResourceFromEntity(Option entity) {
        return new OptionResource(entity.getId(),entity.getTextContent(),entity.getImageUrl());
    }
}
