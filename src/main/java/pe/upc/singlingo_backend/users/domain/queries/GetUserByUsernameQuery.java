package pe.upc.singlingo_backend.users.domain.queries;

public record GetUserByUsernameQuery(String username) {
    public GetUserByUsernameQuery {
        if(username==null){
            throw new IllegalArgumentException("Username cannot be null");
        }
    }
}
