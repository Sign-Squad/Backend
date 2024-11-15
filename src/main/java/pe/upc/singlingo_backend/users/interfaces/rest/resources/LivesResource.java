package pe.upc.singlingo_backend.users.interfaces.rest.resources;

import pe.upc.singlingo_backend.users.domain.model.entities.Role;

public record LivesResource (
        Long id,
        int lives
){
}
