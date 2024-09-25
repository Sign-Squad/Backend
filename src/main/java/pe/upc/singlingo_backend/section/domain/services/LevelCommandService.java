package pe.upc.singlingo_backend.section.domain.services;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Level;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateLevelCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.DeleteLevelCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.UpdateLevelCommand;
import java.util.Optional;

public interface LevelCommandService {
    Optional<Level> handle(CreateLevelCommand command);
    Optional<Level> handle(UpdateLevelCommand command);
    void deleteLevel(DeleteLevelCommand command);
}
