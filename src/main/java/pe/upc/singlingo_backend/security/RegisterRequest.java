package pe.upc.singlingo_backend.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private int lives = 5;
    private String progress;
    private boolean isVip = false;
    private boolean removeAds = false;

}
