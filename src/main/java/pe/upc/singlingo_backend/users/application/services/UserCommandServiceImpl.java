package pe.upc.singlingo_backend.users.application.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;
import pe.upc.singlingo_backend.users.domain.model.commands.CreateUserCommand;
import pe.upc.singlingo_backend.users.domain.model.commands.DeleteUserCommand;
import pe.upc.singlingo_backend.users.domain.model.commands.UpdateLivesCommand;
import pe.upc.singlingo_backend.users.domain.model.commands.UpdateUserCommand;
import pe.upc.singlingo_backend.users.domain.services.UsersCommandService;
import pe.upc.singlingo_backend.users.infraestructure.persistence.jpa.UsersRepository;

import java.util.Optional;
@Service
public class UserCommandServiceImpl implements UsersCommandService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    public UserCommandServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Users> handle(CreateUserCommand command) {
        var user = new Users(command);
        usersRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public Optional<Users> handle(UpdateLivesCommand command) {
        var auxUser = usersRepository.findById(command.id());
        if(auxUser.isPresent()) {
            Users user = auxUser.get();
            user.setLives(command.lives());
            usersRepository.save(user);
            return Optional.of(user);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public Optional<Users> handle(UpdateUserCommand command) {
        var auxUser = usersRepository.findById(command.id());
        if (auxUser.isPresent()) {
            Users user = auxUser.get();
            user.setUsername(command.username());
            user.setEmail(command.email());
            user.setPassword(passwordEncoder.encode(command.password()));
            user.setLives(command.lives());
            user.setProgress(command.progress());
            user.setVip(command.isVip());
            user.setRemoveAds(command.removeAds());
            usersRepository.save(user);
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteUser(DeleteUserCommand command) {
        usersRepository.deleteById(command.id());
    }
}
