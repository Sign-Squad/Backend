package pe.upc.singlingo_backend.users.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.upc.singlingo_backend.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import pe.upc.singlingo_backend.users.domain.model.commands.CreateUserCommand;

import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users extends AuditableAbstractAggregateRoot<Users> {
    private String username;

    private String email;

    private String password;

    private int lives;

    private String progress;

    private boolean isVip = false;

    private boolean removeAds = false;

    public Users(CreateUserCommand command){
        this.username = command.username();
        this.email = command.email();
        this.password = command.email();
        this.lives = command.lives();
        this.progress = command.progress();
        this.isVip = command.isVip();
        this.removeAds = command.removeAds();
    }
}
