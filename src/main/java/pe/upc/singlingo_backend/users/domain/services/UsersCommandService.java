package pe.upc.singlingo_backend.users.domain.services;

import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;
import pe.upc.singlingo_backend.users.domain.model.commands.CreateUserCommand;
import pe.upc.singlingo_backend.users.domain.model.commands.DeleteUserCommand;
import pe.upc.singlingo_backend.users.domain.model.commands.UpdateLivesCommand;
import pe.upc.singlingo_backend.users.domain.model.commands.UpdateUserCommand;

import java.util.Optional;

public interface UsersCommandService {
    Optional<Users> handle(CreateUserCommand command);
    Optional<Users> handle(UpdateLivesCommand command);
    Optional<Users> handle(UpdateUserCommand command);
    void deleteUser(DeleteUserCommand command);
}
