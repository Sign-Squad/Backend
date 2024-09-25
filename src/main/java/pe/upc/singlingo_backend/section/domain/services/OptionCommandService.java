package pe.upc.singlingo_backend.section.domain.services;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Option;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.*;

import java.util.Optional;

public interface OptionCommandService {
    Optional<Option> handle(CreateOptionCommand command);
    Optional<Option> handle(UpdateOptionCommand command);
    void deleteOption(DeleteOptionCommand command);
}
