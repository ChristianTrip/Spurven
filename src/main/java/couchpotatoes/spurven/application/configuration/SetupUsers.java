package couchpotatoes.spurven.application.configuration;

import couchpotatoes.spurven.application.entity.Contact;
import couchpotatoes.spurven.application.entity.ContactType;
import couchpotatoes.spurven.application.repository.ContactRepository;
import couchpotatoes.spurven.application.repository.ContactTypeRepository;
import couchpotatoes.spurven.application.service.ContactService;
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
    private final ContactTypeRepository contactTypeRepository;
    /*private final ContactRepository contactRepository;*/
    private final ContactService contactService;

    public SetupUsers(UserRepository userRepository, ContactTypeRepository contactTypeRepository, ContactService contactService) {

        this.userRepository = userRepository;
        this.passwordUsedByAll = "Kode1234";

        this.contactTypeRepository = contactTypeRepository;
        /*this.contactRepository = contactRepository;*/

        this.contactService = contactService;
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


        // ContactType initialization
        ContactType contactType1 = new ContactType("Good Contacts");
        ContactType contactType2 = new ContactType("Sail Club");
        ContactType contactType3 = new ContactType("Insurance");
        ContactType contactType4 = new ContactType("Repairs");
        ContactType contactType5 = new ContactType("Mechanics");
        ContactType contactType6 = new ContactType("Solar");

        contactTypeRepository.save(contactType1);
        contactTypeRepository.save(contactType2);
        contactTypeRepository.save(contactType3);
        contactTypeRepository.save(contactType4);
        contactTypeRepository.save(contactType5);
        contactTypeRepository.save(contactType6);


        // Contact initialization
        contactService.createContact("CJ", "70 11 00 23", "info@cj-gruppen.dk", 5);
        contactService.createContact("Christian", "28 17 95 12", "christian.jarl@gmail.com", 5);
        contactService.createContact("Niels", "32 64 34 34", "niels.weber@hotmail.com", 1);
        contactService.createContact("Rasmus Christiansen", "32 47 45 88", "rc@viasol.dk", 6);
        contactService.createContact("Benny", "33 64 09 79", "benny.nielsen@outlook.com", 6);

        /*Contact contact1 = new Contact("CJ", "70 11 00 23", "info@cj-gruppen.dk", contactType5);
        Contact contact2 = new Contact("Christian", "28 17 95 12", "christian.jarl@gmail.com", contactType5);
        Contact contact3 = new Contact("Niels", "32 64 34 34", "niels.weber@hotmail.com", contactType1);
        Contact contact4 = new Contact("Rasmus Christiansen", "32 47 45 88", "rc@viasol.dk", contactType6);
        Contact contact5 = new Contact("Benny", "33 64 09 79", "benny.nielsen@outlook.com", contactType6);*/

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
