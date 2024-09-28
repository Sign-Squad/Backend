package pe.upc.singlingo_backend.users.interfaces.rest.transform;

import pe.upc.singlingo_backend.users.domain.model.commands.CreateUserCommand;
import pe.upc.singlingo_backend.users.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.username(),resource.email(), resource.password(), resource.lives(),resource.progress(),resource.isVip(),resource.removeAds(), resource.role());
    }
}
