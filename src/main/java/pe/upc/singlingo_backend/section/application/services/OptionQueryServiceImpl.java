package pe.upc.singlingo_backend.section.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Level;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Option;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetLevelByIDQuery;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetLevelsBySectionIDQuery;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetOptionByIDQuery;
import pe.upc.singlingo_backend.section.domain.services.LevelQueryService;
import pe.upc.singlingo_backend.section.domain.services.OptionQueryService;
import pe.upc.singlingo_backend.section.infraestructure.persistence.jpa.LevelRepository;
import pe.upc.singlingo_backend.section.infraestructure.persistence.jpa.OptionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OptionQueryServiceImpl implements OptionQueryService {
    private final OptionRepository optionRepository;

    public OptionQueryServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }
    @Override
    public Optional<Option> handle(GetOptionByIDQuery query) {
        return optionRepository.findById(query.id());
    }
}
