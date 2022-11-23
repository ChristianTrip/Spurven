package couchpotatoes.spurven.api;

import couchpotatoes.spurven.entity.User;
import couchpotatoes.spurven.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User editUser(@RequestBody User user, @PathVariable int id){
        return userService.editUser(user, id);
    }

}
