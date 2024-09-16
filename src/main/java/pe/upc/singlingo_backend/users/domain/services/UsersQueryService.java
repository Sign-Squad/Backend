package pe.upc.singlingo_backend.users.domain.services;

import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;
import pe.upc.singlingo_backend.users.domain.queries.GetAllUsersQuery;
import pe.upc.singlingo_backend.users.domain.queries.GetUserByEmailQuery;
import pe.upc.singlingo_backend.users.domain.queries.GetUserByIdQuery;
import pe.upc.singlingo_backend.users.domain.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UsersQueryService {
    List<Users> handle(GetAllUsersQuery query);
    Optional<Users> handle(GetUserByIdQuery query);
    Optional<Users> handle(GetUserByEmailQuery query);
    Optional<Users> handle(GetUserByUsernameQuery query);
}
