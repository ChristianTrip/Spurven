package couchpotatoes.spurven.application.service;


import couchpotatoes.spurven.application.entity.Contact;
import couchpotatoes.spurven.application.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }
    public Contact getContact(int id) {
        return contactRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact not found"));
    }
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }
    public Contact editContact(Contact body, int id) {
        Contact contact = getContact(id);
        contact.setName(body.getName());
        contact.setPhone(body.getPhone());
        contact.setEmail(body.getEmail());
        return contactRepository.save(contact);
    }
    public String deleteContact(int id) {
        Contact contact = getContact(id);
        contactRepository.delete(contact);
        return "Contact got deleted";
    }
}
