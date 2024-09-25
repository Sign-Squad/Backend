package pe.upc.singlingo_backend.section.interfaces.rest.resources;

public record LevelResource (
        long id,
        String levelName,
        String description,
        int totalQuestions,
        int SectionID
){
}
