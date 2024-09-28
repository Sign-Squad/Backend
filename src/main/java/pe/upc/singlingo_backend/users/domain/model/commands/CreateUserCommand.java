package pe.upc.singlingo_backend.users.domain.model.commands;

import pe.upc.singlingo_backend.users.domain.model.entities.Role;

public record CreateUserCommand(
        String username,
        String email,
        String password,
        int lives,
        String progress,
        boolean isVip,
        boolean removeAds,
        Role role
) {
}
