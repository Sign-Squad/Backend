package pe.upc.singlingo_backend.section.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.DeleteSectionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.UpdateSectionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetAllSectionsQuery;
import pe.upc.singlingo_backend.section.domain.services.SectionCommandService;
import pe.upc.singlingo_backend.section.domain.services.SectionQueryService;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.CreateSectionResource;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.SectionResource;
import pe.upc.singlingo_backend.section.interfaces.rest.transform.CreateSectionCommandFromResourceAssembler;
import pe.upc.singlingo_backend.section.interfaces.rest.transform.SectionResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/sections", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Sections", description = "Sections management endpoints")
public class SectionController {
    private final SectionCommandService sectionCommandService;
    private final SectionQueryService sectionQueryService;

    public SectionController(SectionCommandService sectionCommandService, SectionQueryService sectionQueryService) {
        this.sectionCommandService = sectionCommandService;
        this.sectionQueryService = sectionQueryService;
    }

    @PostMapping
    public ResponseEntity<SectionResource> createSection(@RequestBody CreateSectionResource createSectionResource) {
        var createSectionCommand = CreateSectionCommandFromResourceAssembler.toCommandResource(createSectionResource);
        var section = sectionCommandService.handle(createSectionCommand);
        if(section.isEmpty()) return ResponseEntity.badRequest().build();

        var sectionResource = SectionResourceFromEntityAssembler.toResourceFromEntity(section.get());
        return ResponseEntity.ok(sectionResource);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SectionResource> updateSection(@PathVariable Long id, @RequestBody CreateSectionResource resource) {
        var updateSectionCommand = new UpdateSectionCommand(id, resource.sectionName(), resource.description());
        var section = sectionCommandService.handle(updateSectionCommand);
        if(section.isEmpty()) return ResponseEntity.badRequest().build();

        var sectionResource = SectionResourceFromEntityAssembler.toResourceFromEntity(section.get());
        return ResponseEntity.ok(sectionResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable Long id) {
        var deleteSectionCommand = new DeleteSectionCommand(id);
        sectionCommandService.deleteSection(deleteSectionCommand);
        return ResponseEntity.noContent().build();
    }
    @GetMapping()
    public ResponseEntity<List<SectionResource>> getAllSections() {
        var getAllSectionsQuery = new GetAllSectionsQuery();
        var sections = sectionQueryService.handle(getAllSectionsQuery);
        if (sections.isEmpty()) {return ResponseEntity.badRequest().build();}

        var sectionResource = sections.stream()
                .map(SectionResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(sectionResource);
    }
}
