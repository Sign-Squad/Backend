package pe.upc.singlingo_backend.users.application.services;

import org.springframework.stereotype.Service;
import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;
import pe.upc.singlingo_backend.users.domain.model.queries.GetAllUsersQuery;
import pe.upc.singlingo_backend.users.domain.model.queries.GetUserByEmailQuery;
import pe.upc.singlingo_backend.users.domain.model.queries.GetUserByIdQuery;
import pe.upc.singlingo_backend.users.domain.model.queries.GetUserByUsernameQuery;
import pe.upc.singlingo_backend.users.domain.services.UsersQueryService;
import pe.upc.singlingo_backend.users.infraestructure.persistence.jpa.UsersRepository;

import java.util.List;
import java.util.Optional;
@Service
public class UserQueryServiceImpl implements UsersQueryService {
    private final UsersRepository usersRepository;

    public UserQueryServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public List<Users> handle(GetAllUsersQuery query)
    {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> handle(GetUserByIdQuery query)
    {
        return usersRepository.findUserById(query.id());
    }

    @Override
    public Optional<Users> handle(GetUserByEmailQuery query) {
        return usersRepository.findUserByEmail(query.email());
    }

    @Override
    public Optional<Users> handle(GetUserByUsernameQuery query) {
        return usersRepository.findUserByUsername(query.username());

    }
}
