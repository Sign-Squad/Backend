package pe.upc.singlingo_backend.section.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.DeleteLevelCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.UpdateLevelCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetLevelByIDQuery;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetLevelsBySectionIDQuery;
import pe.upc.singlingo_backend.section.domain.services.LevelCommandService;
import pe.upc.singlingo_backend.section.domain.services.LevelQueryService;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.CreateLevelResource;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.LevelResource;
import pe.upc.singlingo_backend.section.interfaces.rest.transform.CreateLevelCommandFromResourceAssembler;
import pe.upc.singlingo_backend.section.interfaces.rest.transform.LevelResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/levels", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Levels", description = "Levels management endpoints")
public class LevelController {
    private final LevelCommandService levelCommandService;
    private final LevelQueryService levelQueryService;

    public LevelController(LevelCommandService levelCommandService, LevelQueryService levelQueryService) {
        this.levelCommandService = levelCommandService;
        this.levelQueryService = levelQueryService;
    }

    @PostMapping
    public ResponseEntity<LevelResource> createLevel(@RequestBody CreateLevelResource createLevelResource) {
        var createLevelCommand = CreateLevelCommandFromResourceAssembler.toCommandResource(createLevelResource);
        var level = levelCommandService.handle(createLevelCommand);
        if(level.isEmpty()) return ResponseEntity.badRequest().build();

        var levelResource = LevelResourceFromEntityAssembler.toResourceFromEntity(level.get());
        return ResponseEntity.ok(levelResource);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LevelResource> updateLevel(@PathVariable Long id, @RequestBody CreateLevelResource resource) {
        var updateLevelCommand = new UpdateLevelCommand(id, resource.levelName(),resource.iconUrl(), resource.position(), resource.totalQuestions(),resource.SectionID());
        var level = levelCommandService.handle(updateLevelCommand);
        if(level.isEmpty()) return ResponseEntity.badRequest().build();

        var levelResource = LevelResourceFromEntityAssembler.toResourceFromEntity(level.get());
        return ResponseEntity.ok(levelResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLevel(@PathVariable Long id) {
        var deleteLevelCommand = new DeleteLevelCommand(id);
        levelCommandService.deleteLevel(deleteLevelCommand);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/section/{sectionID}")
    public ResponseEntity<List<LevelResource>> getLevelsBySectionID(@PathVariable Long sectionID) {
        var getLevelsBySectionID = new GetLevelsBySectionIDQuery(sectionID);
        var levels = levelQueryService.handle(getLevelsBySectionID);
        if (levels.isEmpty()) {return ResponseEntity.badRequest().build();}

        var levelsResource = levels.stream()
                .map(LevelResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(levelsResource);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<LevelResource> getLevelById(@PathVariable Long id) {
        var getLevelByIdQuery = new GetLevelByIDQuery(id);
        var level = levelQueryService.handle(getLevelByIdQuery);
        if(level.isEmpty()) return ResponseEntity.badRequest().build();
        var levelResource = LevelResourceFromEntityAssembler.toResourceFromEntity(level.get());
        return ResponseEntity.ok(levelResource);
    }
}
