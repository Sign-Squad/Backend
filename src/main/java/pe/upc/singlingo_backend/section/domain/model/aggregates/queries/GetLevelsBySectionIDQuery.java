package pe.upc.singlingo_backend.section.domain.model.aggregates.queries;

public record GetLevelsBySectionIDQuery(Long sectionID) {
    public GetLevelsBySectionIDQuery {
        if(sectionID==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(sectionID<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
