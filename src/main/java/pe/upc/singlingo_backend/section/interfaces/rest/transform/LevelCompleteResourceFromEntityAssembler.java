package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Level;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.LevelCompleteResource;

public class LevelCompleteResourceFromEntityAssembler {
    public static LevelCompleteResource toResourceFromEntity(Level entity) {
        return new LevelCompleteResource(entity.getId(), entity.isLevelComplete());
    }
}
