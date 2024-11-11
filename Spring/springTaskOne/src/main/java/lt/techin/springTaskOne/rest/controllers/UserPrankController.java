package lt.techin.springTaskOne.rest.controllers;

import lt.techin.springTaskOne.rest.users.UserPrank;
import lt.techin.springTaskOne.rest.dto.UserRequest;
import lt.techin.springTaskOne.rest.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserPrankController {

    private UserService userService;

    public UserPrankController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserPrank> getAll() {
        return userService.getAll();
    }

    @PostMapping
    ResponseEntity<UserPrank> createUser(@RequestBody UserRequest user){
        UserPrank newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{id}")
    UserPrank getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<UserPrank> updateUser(@RequestBody UserRequest user, @PathVariable Long id){
        UserPrank updatedUser = userService.updateUser(user, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
