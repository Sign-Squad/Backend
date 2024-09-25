package pe.upc.singlingo_backend.section.domain.model.aggregates.queries;

public record GetOptionByIDQuery(Long id) {
    public GetOptionByIDQuery {
        if(id==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(id<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
