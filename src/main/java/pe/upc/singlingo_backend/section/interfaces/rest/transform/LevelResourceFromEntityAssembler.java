package pe.upc.singlingo_backend.section.interfaces.rest.transform;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Level;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.LevelResource;
import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;
import pe.upc.singlingo_backend.users.interfaces.rest.resources.UserResource;

public class LevelResourceFromEntityAssembler {
    public static LevelResource toResourceFromEntity(Level entity) {
        return new LevelResource(entity.getId(), entity.getLevelName(), entity.getDescription(), entity.getTotalQuestions(),entity.getSectionID());
    }
}
