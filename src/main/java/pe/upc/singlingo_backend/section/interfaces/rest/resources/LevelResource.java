package pe.upc.singlingo_backend.section.interfaces.rest.resources;

public record LevelResource (
        long id,
        String levelName,
        String iconUrl,
        int position,
        int totalQuestions,
        int SectionID
){
}
