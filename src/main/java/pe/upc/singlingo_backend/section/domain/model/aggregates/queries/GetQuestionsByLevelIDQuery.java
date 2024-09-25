package pe.upc.singlingo_backend.section.domain.model.aggregates.queries;

public record GetQuestionsByLevelIDQuery(Long levelID) {
    public GetQuestionsByLevelIDQuery {
        if(levelID==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(levelID<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
