package pe.upc.singlingo_backend.section.interfaces.rest.resources;

public record CreateLevelResource (
        String levelName,
        String iconUrl,
        int position,
        int totalQuestions,
        int SectionID
){
}
