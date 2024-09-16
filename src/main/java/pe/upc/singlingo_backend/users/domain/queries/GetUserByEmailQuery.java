package pe.upc.singlingo_backend.users.domain.queries;

public record GetUserByEmailQuery(String email) {
    public GetUserByEmailQuery {
        if(email==null){
            throw new IllegalArgumentException("Email cannot be null");
        }
    }
}
