package pe.upc.singlingo_backend.section.domain.services;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Option;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetOptionByIDQuery;

import java.util.Optional;

public interface OptionQueryService {
    Optional<Option> handle(GetOptionByIDQuery query);
}
