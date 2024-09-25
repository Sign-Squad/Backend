package pe.upc.singlingo_backend.section.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Level;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.CreateLevelCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.DeleteLevelCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.UpdateLevelCommand;
import pe.upc.singlingo_backend.section.domain.services.LevelCommandService;
import pe.upc.singlingo_backend.section.infraestructure.persistence.jpa.LevelRepository;

import java.util.Optional;
@Service
public class LevelCommandServiceImpl implements LevelCommandService {
    private final LevelRepository levelRepository;

    public LevelCommandServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public Optional<Level> handle(CreateLevelCommand command) {
        var level = new Level(command);
        levelRepository.save(level);
        return Optional.of(level);
    }

    @Override
    public Optional<Level> handle(UpdateLevelCommand command) {
        var auxLevel = levelRepository.findById(command.id());
        if (auxLevel.isPresent()) {
            Level level = auxLevel.get();
            level.setLevelName(command.levelName());
            level.setDescription(command.description());
            level.setTotalQuestions(command.totalQuestions());
            level.setSectionID(command.SectionID());
            levelRepository.save(level);
            return Optional.of(level);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteLevel(DeleteLevelCommand command) {
        levelRepository.deleteById(command.id());
    }
}
