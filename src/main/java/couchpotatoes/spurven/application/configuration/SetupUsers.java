package couchpotatoes.spurven.application.configuration;

import couchpotatoes.spurven.security.entity.Role;
import couchpotatoes.spurven.security.entity.User;
import couchpotatoes.spurven.security.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class SetupUsers implements ApplicationRunner {

    private final UserRepository userRepository;

    private final String passwordUsedByAll;

    public SetupUsers(UserRepository userRepository) {

        this.userRepository = userRepository;
        this. passwordUsedByAll = "Kode1234";

    }

    @Override
    public void run(ApplicationArguments args) {

        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");

        User newUser1 = new User("hjorten", passwordUsedByAll, "Andreas", "Hjort", "andreas.hjort28@gmail.com", "20 87 67 07");
        User newUser2 = new User("svendSvedig", passwordUsedByAll, "Svend", "Emil Gude Svendsen", "svend.gude@gmail.com", "29 29 00 05");
        User newUser3 = new User("chrisK", passwordUsedByAll, "Christoffer", "Kristensen", "christoffer.kristensen98@gmail.com", "29 89 15 15");
        User newUser4 = new User("gurd", passwordUsedByAll, "Sigurd", "Bang", "sigurdbang2@gmail.com", "51 94 73 74");
        newUser1.addRole(Role.ADMIN);
        newUser2.addRole(Role.ADMIN);
        newUser3.addRole(Role.ADMIN);
        newUser4.addRole(Role.ADMIN);

        userRepository.save(newUser1);
        userRepository.save(newUser2);
        userRepository.save(newUser3);
        userRepository.save(newUser4);
/*
        User user1 = new User("hjorten", passwordUsedByAll);
        User user2 = new User("svendSvedig", passwordUsedByAll);
        User user3 = new User("chrisK", passwordUsedByAll);
        User user4 = new User("gurd", passwordUsedByAll);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.USER);
        user4.addRole(Role.ADMIN);
        userRepository.save(newUser1);
        userRepository.save(newUser2);
        userRepository.save(newUser3);
        userRepository.save(newUser4);

         */

    }

}
