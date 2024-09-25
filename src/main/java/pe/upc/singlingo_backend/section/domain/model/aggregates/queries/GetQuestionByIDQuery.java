package pe.upc.singlingo_backend.section.domain.model.aggregates.queries;

public record GetQuestionByIDQuery(Long id) {
    public GetQuestionByIDQuery {
        if(id==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(id<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
