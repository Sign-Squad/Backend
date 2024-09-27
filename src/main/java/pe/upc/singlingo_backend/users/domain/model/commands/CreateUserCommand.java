package pe.upc.singlingo_backend.users.domain.model.commands;

public record CreateUserCommand(
        String username,
        String email,
        String password,
        int lives,
        String progress,
        boolean isVip,
        boolean removeAds
) {
}
