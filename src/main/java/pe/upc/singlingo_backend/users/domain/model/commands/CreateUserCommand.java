package pe.upc.singlingo_backend.users.domain.model.commands;

public record CreateUserCommand(
        String username,
        String email,
        int lives,
        String progress,
        boolean isVip,
        boolean removeAds
) {
}
