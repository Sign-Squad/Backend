package pe.upc.singlingo_backend.section.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Section;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetAllSectionsQuery;
import pe.upc.singlingo_backend.section.domain.services.SectionQueryService;
import pe.upc.singlingo_backend.section.infraestructure.persistence.jpa.SectionRepository;

import java.util.List;
@Service
public class SectionQueryServiceImpl implements SectionQueryService {
    private final SectionRepository sectionRepository;

    public SectionQueryServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public List<Section> handle(GetAllSectionsQuery query) {
        return sectionRepository.findAll();
    }
}
