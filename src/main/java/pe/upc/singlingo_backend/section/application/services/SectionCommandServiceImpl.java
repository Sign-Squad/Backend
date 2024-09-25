package pe.upc.singlingo_backend.section.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Section;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateSectionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.DeleteSectionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.UpdateSectionCommand;
import pe.upc.singlingo_backend.section.domain.services.SectionCommandService;
import pe.upc.singlingo_backend.section.infraestructure.persistence.jpa.SectionRepository;

import java.util.Optional;
@Service
public class SectionCommandServiceImpl implements SectionCommandService {
    private final SectionRepository sectionRepository;

    public SectionCommandServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Optional<Section> handle(CreateSectionCommand command) {
        var section = new Section(command);
        sectionRepository.save(section);
        return Optional.of(section);
    }

    @Override
    public Optional<Section> handle(UpdateSectionCommand command) {
        var auxSection = sectionRepository.findById(command.id());
        if (auxSection.isPresent()) {
            Section section = auxSection.get();
            section.setSectionName(command.sectionName());
            section.setDescription(command.description());
            sectionRepository.save(section);
            return Optional.of(section);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteSection(DeleteSectionCommand command) {
        sectionRepository.deleteById(command.id());
    }
}
