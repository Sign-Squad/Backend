package pe.upc.singlingo_backend.users.interfaces.rest.transform;

import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;
import pe.upc.singlingo_backend.users.interfaces.rest.resources.LivesResource;
import pe.upc.singlingo_backend.users.interfaces.rest.resources.UserResource;

public class UserLivesResource {
    public static LivesResource toResourceFromEntity(Users user) {
        return new LivesResource(user.getId(), user.getLives());
    }
}
