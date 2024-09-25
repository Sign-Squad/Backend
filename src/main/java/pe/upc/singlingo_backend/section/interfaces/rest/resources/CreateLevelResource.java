package pe.upc.singlingo_backend.section.interfaces.rest.resources;

public record CreateLevelResource (
        String levelName,
        String description,
        int totalQuestions,
        int SectionID
){
}
