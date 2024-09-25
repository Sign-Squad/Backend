package pe.upc.singlingo_backend.section.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Level;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetLevelByIDQuery;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetLevelsBySectionIDQuery;
import pe.upc.singlingo_backend.section.domain.services.LevelQueryService;
import pe.upc.singlingo_backend.section.infraestructure.persistence.jpa.LevelRepository;

import java.util.List;
import java.util.Optional;
@Service
public class LevelQueryServiceImpl implements LevelQueryService {
    private final LevelRepository levelRepository;

    public LevelQueryServiceImpl(LevelRepository repository) {
        this.levelRepository = repository;
    }

    @Override
    public Optional<Level> handle(GetLevelByIDQuery query) {
        return levelRepository.findById(query.id());
    }

    @Override
    public List<Level> handle(GetLevelsBySectionIDQuery query) {
        return levelRepository.findLevelsBySectionID(query.sectionID());
    }
}
