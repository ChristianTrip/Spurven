package couchpotatoes.spurven.application.api;


import couchpotatoes.spurven.application.dto.ContactRequest;
import couchpotatoes.spurven.application.entity.Contact;
import couchpotatoes.spurven.application.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping() //--Get the List of Contacts. (READ) (User).
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}") //--get a Contact by by /1 (READ) (User).
    public Contact getContact(@PathVariable int id){
        return contactService.getContact(id);
    }

    @PostMapping("/") //--CREATE a Contact by id (CREATE) (User).
    public Contact createContact(@RequestBody ContactRequest contactRequest){
        return contactService.createContact(contactRequest.getName(), contactRequest.getPhone(), contactRequest.getEmail(), contactRequest.getContactTypeId());
    }

    @PutMapping("/{id}") //--EDIT a Contact by id (EDIT) (User).
    public Contact editContact(@RequestBody Contact contact, @PathVariable int id ){
        return contactService.editContact(contact, id);
    }

    @DeleteMapping("/{id}") //--DELETE a Contact by id (EDIT) (User).
    public String deleteContact(@PathVariable int id){
        return contactService.deleteContact(id);
    }

}
