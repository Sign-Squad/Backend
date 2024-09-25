package pe.upc.singlingo_backend.section.interfaces.rest.resources;

public record QuestionResource (
        long id,
        String questionType,
        String title,
        String content,
        String correctAnswer,
        int levelID
){
}
