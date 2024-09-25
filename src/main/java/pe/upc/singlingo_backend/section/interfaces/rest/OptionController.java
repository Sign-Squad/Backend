package pe.upc.singlingo_backend.section.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.DeleteOptionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.UpdateOptionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetOptionByIDQuery;
import pe.upc.singlingo_backend.section.domain.services.OptionCommandService;
import pe.upc.singlingo_backend.section.domain.services.OptionQueryService;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.CreateOptionResource;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.OptionResource;
import pe.upc.singlingo_backend.section.interfaces.rest.transform.CreateOptionCommandFromResourceAssembler;
import pe.upc.singlingo_backend.section.interfaces.rest.transform.OptionResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "/api/v1/options", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Options", description = "Options management endpoints")
public class OptionController {
    private final OptionCommandService optionCommandService;
    private final OptionQueryService optionQueryService;

    public OptionController(OptionCommandService optionCommandService, OptionQueryService optionQueryService) {
        this.optionCommandService = optionCommandService;
        this.optionQueryService = optionQueryService;
    }

    @PostMapping
    public ResponseEntity<OptionResource> createOption(@RequestBody CreateOptionResource createOptionResource) {
        var createOptionCommand = CreateOptionCommandFromResourceAssembler.toCommandResource(createOptionResource);
        var option = optionCommandService.handle(createOptionCommand);
        if(option.isEmpty()) return ResponseEntity.badRequest().build();

        var customerResource = OptionResourceFromEntityAssembler.toResourceFromEntity(option.get());
        return ResponseEntity.ok(customerResource);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OptionResource> updateOption(@PathVariable Long id, @RequestBody CreateOptionResource resource) {
        var updateOptionCommand = new UpdateOptionCommand(id, resource.textContent(), resource.imageUrl());
        var option = optionCommandService.handle(updateOptionCommand);
        if(option.isEmpty()) return ResponseEntity.badRequest().build();

        var optionResource = OptionResourceFromEntityAssembler.toResourceFromEntity(option.get());
        return ResponseEntity.ok(optionResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
        var deleteOptionCommand = new DeleteOptionCommand(id);
        optionCommandService.deleteOption(deleteOptionCommand);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<OptionResource> getOptionById(@PathVariable Long id) {
        var getOptionByIdQuery = new GetOptionByIDQuery(id);
        var option = optionQueryService.handle(getOptionByIdQuery);
        if(option.isEmpty()) return ResponseEntity.badRequest().build();
        var optionResource = OptionResourceFromEntityAssembler.toResourceFromEntity(option.get());
        return ResponseEntity.ok(optionResource);
    }
}
