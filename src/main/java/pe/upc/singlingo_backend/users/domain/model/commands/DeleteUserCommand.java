package pe.upc.singlingo_backend.users.domain.model.commands;

import jakarta.validation.constraints.NotNull;

public record DeleteUserCommand(
        @NotNull Long id
) {
}
