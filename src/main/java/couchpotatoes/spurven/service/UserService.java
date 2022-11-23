package couchpotatoes.spurven.service;

import couchpotatoes.spurven.entity.User;
import couchpotatoes.spurven.repository.UserRepository;
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

    public User getUserById(int id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "User with id: " + id + ", could not be found"));
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User editUser(User body, int id){
        User user = getUserById(id);
        user.setName(body.getName());
        return userRepository.save(user);
    }

}
