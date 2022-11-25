package couchpotatoes.spurven.application.api;

import couchpotatoes.spurven.application.entity.User;
import couchpotatoes.spurven.application.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUserById(username);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/{username}")
    public User editUser(@RequestBody User user, @PathVariable String username){
        return userService.editUser(user, username);
    }

}
