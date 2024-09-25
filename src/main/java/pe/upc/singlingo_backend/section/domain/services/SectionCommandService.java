package pe.upc.singlingo_backend.section.domain.services;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Section;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.*;

import java.util.Optional;

public interface SectionCommandService {
    Optional<Section> handle(CreateSectionCommand createSectionCommand);
    Optional<Section> handle(UpdateSectionCommand command);
    void deleteSection(DeleteSectionCommand command);
}
