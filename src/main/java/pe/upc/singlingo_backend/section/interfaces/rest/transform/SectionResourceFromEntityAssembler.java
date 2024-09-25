package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Section;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.SectionResource;

public class SectionResourceFromEntityAssembler {
    public static SectionResource toResourceFromEntity(Section entity) {
        return new SectionResource(entity.getId(),entity.getSectionName(),entity.getDescription());
    }
}
