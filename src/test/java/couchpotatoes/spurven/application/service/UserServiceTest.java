package couchpotatoes.spurven.application.service;

import couchpotatoes.spurven.application.entity.User;
import couchpotatoes.spurven.application.repository.UserRepository;
import couchpotatoes.spurven.security.entity.UserWithRoles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepo;

    @Autowired
    UserService userServ;

    @BeforeEach
    public void setup(){
        userServ = new UserService(userRepo);
    }


    @Test
    void getUserById() {
        User u1 = new User("Charles","Darwin","cd@test.dk","50505050");
        u1.setUsername("charlesdarwin");
        Mockito.when(userRepo.findById("charlesdarwin")).thenReturn(Optional.of(u1));

        UserWithRoles foundUser = userServ.getUserById("charlesdarwin");
        assertEquals("charlesdarwin",foundUser.getUsername());

    }

    @Test
    void getAllUsers() {
        Mockito.when(userRepo.findAll()).thenReturn(List.of(
                new User("Charles","Darwin","cd@test.dk","50505050"),
                new User("Emma", "Wedgwood", "ew@test.dk","60606060")
        ));

        List<User> foundUsers = userServ.getAllUsers();

        assertEquals(2, foundUsers.size());
        assertEquals("Charles",foundUsers.get(0).getFirstName());
    }

    @Test
    void editUser() {

    }
}