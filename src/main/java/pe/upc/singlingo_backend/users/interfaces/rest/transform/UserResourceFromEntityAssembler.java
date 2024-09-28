package pe.upc.singlingo_backend.users.interfaces.rest.transform;

import pe.upc.singlingo_backend.users.domain.model.aggregates.Users;
import pe.upc.singlingo_backend.users.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(Users user) {
        return new UserResource(user.getId(),user.getUsername(),user.getEmail(), user.getPassword(), user.getLives(),user.getProgress(),user.isVip(),user.isRemoveAds(), user.getRole());
    }
}
