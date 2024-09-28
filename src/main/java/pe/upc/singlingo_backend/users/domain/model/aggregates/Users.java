package pe.upc.singlingo_backend.users.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pe.upc.singlingo_backend.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import pe.upc.singlingo_backend.users.domain.model.commands.CreateUserCommand;
import pe.upc.singlingo_backend.users.domain.model.entities.Role;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users extends AuditableAbstractAggregateRoot<Users> implements UserDetails {
    @Column(nullable = false)
    private String username;
    private String email;
    private String password;
    private int lives;
    private String progress;
    private boolean isVip = false;
    private boolean removeAds = false;
    @Enumerated(EnumType.STRING)
    Role role;

    public Users(CreateUserCommand command){
        this.username = command.username();
        this.email = command.email();
        this.password = command.email();
        this.lives = command.lives();
        this.progress = command.progress();
        this.isVip = command.isVip();
        this.removeAds = command.removeAds();
        this.role = command.role();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
