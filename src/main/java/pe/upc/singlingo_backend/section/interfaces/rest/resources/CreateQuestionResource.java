package pe.upc.singlingo_backend.section.interfaces.rest.resources;

public record CreateQuestionResource(
        String questionType,
        String title,
        String correctAnswer,
        int levelID
) {
}
