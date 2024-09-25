package pe.upc.singlingo_backend.section.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Option;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.*;
import pe.upc.singlingo_backend.section.domain.services.OptionCommandService;
import pe.upc.singlingo_backend.section.infraestructure.persistence.jpa.OptionRepository;

import java.util.Optional;

@Service
public class OptionCommandServiceImpl implements OptionCommandService {
    private final OptionRepository optionRepository;

    public OptionCommandServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public Optional<Option> handle(CreateOptionCommand command) {
        var option = new Option(command);
        optionRepository.save(option);
        return Optional.of(option);
    }

    @Override
    public Optional<Option> handle(UpdateOptionCommand command) {
        var auxOption = optionRepository.findById(command.id());
        if (auxOption.isPresent()) {
            Option option = auxOption.get();
            option.setTextContent(command.textContent());
            option.setImageUrl(command.imageUrl());
            optionRepository.save(option);
            return Optional.of(option);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteOption(DeleteOptionCommand command) {
        optionRepository.deleteById(command.id());
    }
}
