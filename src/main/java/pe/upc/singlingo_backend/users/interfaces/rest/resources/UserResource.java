package pe.upc.singlingo_backend.users.interfaces.rest.resources;

import pe.upc.singlingo_backend.users.domain.model.entities.Role;

public record UserResource(
        Long id,
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
