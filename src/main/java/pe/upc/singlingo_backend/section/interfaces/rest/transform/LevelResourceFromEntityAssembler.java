package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Level;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.LevelResource;

public class LevelResourceFromEntityAssembler {
    public static LevelResource toResourceFromEntity(Level entity) {
        return new LevelResource(entity.getId(), entity.getLevelName(), entity.getIconUrl(), entity.getPosition(), entity.getTotalQuestions(),entity.getSectionID(), entity.isLevelComplete());
    }
}
