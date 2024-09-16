package pe.upc.singlingo_backend.users.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserCommand(
        @NotBlank Long id,
        @NotBlank String username,
        @NotBlank String email,
        @NotBlank int lives,
        @NotBlank String progress,
        @NotBlank boolean isVip,
        @NotBlank boolean removeAds
) {
}
