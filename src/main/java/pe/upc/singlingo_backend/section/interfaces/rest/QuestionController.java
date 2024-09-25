package pe.upc.singlingo_backend.section.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.DeleteQuestionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.commands.UpdateQuestionCommand;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetQuestionByIDQuery;
import pe.upc.singlingo_backend.section.domain.model.aggregates.queries.GetQuestionsByLevelIDQuery;
import pe.upc.singlingo_backend.section.domain.services.QuestionCommandService;
import pe.upc.singlingo_backend.section.domain.services.QuestionQueryService;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.CreateQuestionResource;
import pe.upc.singlingo_backend.section.interfaces.rest.resources.QuestionResource;
import pe.upc.singlingo_backend.section.interfaces.rest.transform.CreateQuestionCommandFromResourceAssembler;
import pe.upc.singlingo_backend.section.interfaces.rest.transform.LevelResourceFromEntityAssembler;
import pe.upc.singlingo_backend.section.interfaces.rest.transform.QuestionResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/questions", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Questions", description = "Questions management endpoints")
public class QuestionController {
    private final QuestionCommandService questionCommandService;
    private final QuestionQueryService questionQueryService;


    public QuestionController(QuestionCommandService questionCommandService, QuestionQueryService questionQueryService) {
        this.questionCommandService = questionCommandService;
        this.questionQueryService = questionQueryService;
    }

    @PostMapping
    public ResponseEntity<QuestionResource> createQuestion(@RequestBody CreateQuestionResource createQuestionResource) {
        var createQuestionCommand = CreateQuestionCommandFromResourceAssembler.toCommandResource(createQuestionResource);
        var question = questionCommandService.handle(createQuestionCommand);
        if(question.isEmpty()) return ResponseEntity.badRequest().build();

        var customerResource = QuestionResourceFromEntityAssembler.toResourceFromEntity(question.get());
        return ResponseEntity.ok(customerResource);
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuestionResource> updateQuestion(@PathVariable Long id, @RequestBody CreateQuestionResource resource) {
        var updateQuestionCommand = new UpdateQuestionCommand(id, resource.questionType(), resource.title(), resource.content(), resource.correctAnswer(), resource.levelID());
        var question = questionCommandService.handle(updateQuestionCommand);
        if(question.isEmpty()) return ResponseEntity.badRequest().build();

        var userResource = QuestionResourceFromEntityAssembler.toResourceFromEntity(question.get());
        return ResponseEntity.ok(userResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        var deleteQuestionCommand = new DeleteQuestionCommand(id);
        questionCommandService.deleteQuestion(deleteQuestionCommand);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/level/{levelID}")
    public ResponseEntity<List<QuestionResource>> getQuestionsByLevelID(@PathVariable Long levelID) {
        var getQuestionByLevelID = new GetQuestionsByLevelIDQuery(levelID);
        var questions = questionQueryService.handle(getQuestionByLevelID);
        if (questions.isEmpty()) {return ResponseEntity.badRequest().build();}

        var questionResource = questions.stream()
                .map(QuestionResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(questionResource);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<QuestionResource> getQuestionById(@PathVariable Long id) {
        var getQuestionByIdQuery = new GetQuestionByIDQuery(id);
        var question = questionQueryService.handle(getQuestionByIdQuery);
        if(question.isEmpty()) return ResponseEntity.badRequest().build();
        var questionResource = QuestionResourceFromEntityAssembler.toResourceFromEntity(question.get());
        return ResponseEntity.ok(questionResource);
    }
}
