package pe.upc.singlingo_backend.users.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findUserByEmail(String email);
    Optional<Users> findUserByUsername(String username);
    Optional<Users> findUserById(Long id);
}
