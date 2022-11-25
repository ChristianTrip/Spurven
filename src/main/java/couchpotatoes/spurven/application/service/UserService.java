package couchpotatoes.spurven.application.service;

import couchpotatoes.spurven.application.entity.User;
import couchpotatoes.spurven.application.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String username) {
        return userRepository.findById(username).
                orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "User with username: " + username + ", could not be found"));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User editUser(User body, String username){
        User user = getUserById(username);
        user.setUsername(body.getUsername());
        return userRepository.save(user);
    }

}
