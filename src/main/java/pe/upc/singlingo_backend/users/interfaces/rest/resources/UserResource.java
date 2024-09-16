package pe.upc.singlingo_backend.users.interfaces.rest.resources;

public record UserResource(
        Long id,
        String username,
        String email,
        int lives,
        String progress,
        boolean isVip,
        boolean removeAds
) {
}
