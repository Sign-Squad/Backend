package pe.upc.singlingo_backend.section.domain.services;

import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Section;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetAllSectionsQuery;

import java.util.List;

public interface SectionQueryService {
    List<Section> handle(GetAllSectionsQuery query);
}
