package pe.upc.singlingo_backend.users.interfaces.rest.resources;

public record UserResource(
        Long id,
        String username,
        String email,
        String password,
        int lives,
        String progress,
        boolean isVip,
        boolean removeAds
) {
}
