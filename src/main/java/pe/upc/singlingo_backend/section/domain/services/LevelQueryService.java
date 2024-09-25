package pe.upc.singlingo_backend.section.domain.services;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Level;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetLevelByIDQuery;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetLevelsBySectionIDQuery;

import java.util.List;
import java.util.Optional;

public interface LevelQueryService {
    Optional<Level> handle(GetLevelByIDQuery query);
    List<Level> handle(GetLevelsBySectionIDQuery query);
}
