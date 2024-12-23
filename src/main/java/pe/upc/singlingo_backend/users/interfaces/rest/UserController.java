package pe.upc.singlingo_backend.users.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.upc.singlingo_backend.users.domain.model.commands.DeleteUserCommand;
import pe.upc.singlingo_backend.users.domain.model.commands.UpdateLivesCommand;
import pe.upc.singlingo_backend.users.domain.model.commands.UpdateUserCommand;
import pe.upc.singlingo_backend.users.domain.model.queries.GetAllUsersQuery;
import pe.upc.singlingo_backend.users.domain.model.queries.GetUserByEmailQuery;
import pe.upc.singlingo_backend.users.domain.model.queries.GetUserByIdQuery;
import pe.upc.singlingo_backend.users.domain.model.queries.GetUserByUsernameQuery;
import pe.upc.singlingo_backend.users.domain.services.UsersCommandService;
import pe.upc.singlingo_backend.users.domain.services.UsersQueryService;
import pe.upc.singlingo_backend.users.interfaces.rest.resources.CreateUserResource;
import pe.upc.singlingo_backend.users.interfaces.rest.resources.LivesResource;
import pe.upc.singlingo_backend.users.interfaces.rest.resources.UpdateLivesResource;
import pe.upc.singlingo_backend.users.interfaces.rest.resources.UserResource;
import pe.upc.singlingo_backend.users.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import pe.upc.singlingo_backend.users.interfaces.rest.transform.UserLivesResource;
import pe.upc.singlingo_backend.users.interfaces.rest.transform.UserResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Users", description = "Users management endpoints")
@Validated
public class UserController {
    private final UsersCommandService usersCommandService;
    private final UsersQueryService usersQueryService;

    public UserController(UsersCommandService usersCommandService, UsersQueryService usersQueryService) {
        this.usersCommandService = usersCommandService;
        this.usersQueryService = usersQueryService;
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource createUserResource) {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandResource(createUserResource);
        var user = usersCommandService.handle(createUserCommand);
        if(user.isEmpty()) return ResponseEntity.badRequest().build();

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResource> updateUser(@PathVariable Long id, @RequestBody CreateUserResource resource) {
        var updateUserCommand = new UpdateUserCommand(id, resource.username(), resource.email(), resource.password(), resource.lives(),resource.progress(),resource.isVip(),resource.removeAds());
        var user = usersCommandService.handle(updateUserCommand);
        if(user.isEmpty()) return ResponseEntity.badRequest().build();

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
    @PatchMapping("/lives/{id}")
    public ResponseEntity<LivesResource> updateLives(@PathVariable Long id, @RequestBody UpdateLivesResource resource) {
        var updateLivesUserCommand = new UpdateLivesCommand(id, resource.lives());
        var user = usersCommandService.handle(updateLivesUserCommand);
        if (user.isEmpty()) return ResponseEntity.badRequest().build();

        var userLivesResource = UserLivesResource.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userLivesResource);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        var deleteUserCommand = new DeleteUserCommand(id);
        usersCommandService.deleteUser(deleteUserCommand);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<UserResource>> getAllUsers() {
        var getAllUsersQuery = new GetAllUsersQuery();
        var users = usersQueryService.handle(getAllUsersQuery);
        if (users.isEmpty()) {return ResponseEntity.badRequest().build();}

        var usersResource = users.stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usersResource);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id) {
        var getUserByIdQuery = new GetUserByIdQuery(id);
        var user = usersQueryService.handle(getUserByIdQuery);
        if(user.isEmpty()) return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResource> getUserByEmail(@PathVariable String email) {
        var getUserByEmailQuery = new GetUserByEmailQuery(email);
        var user = usersQueryService.handle(getUserByEmailQuery);
        if(user.isEmpty()) return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<UserResource> getUserByUsername(@PathVariable String username) {
        var getUserByUsernameQuery = new GetUserByUsernameQuery(username);
        var user = usersQueryService.handle(getUserByUsernameQuery);
        if(user.isEmpty()) return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
}
