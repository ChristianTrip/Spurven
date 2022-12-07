package couchpotatoes.spurven.application.service;


import couchpotatoes.spurven.application.entity.Contact;
import couchpotatoes.spurven.application.entity.ContactType;
import couchpotatoes.spurven.application.repository.ContactRepository;
import couchpotatoes.spurven.application.repository.ContactTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactTypeRepository contactTypeRepository;

    public ContactService(ContactRepository contactRepository, ContactTypeRepository contactTypeRepository){
        this.contactRepository = contactRepository;
        this.contactTypeRepository = contactTypeRepository;
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }
    public Contact getContact(int id) {
        return contactRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact not found"));
    }

    public Contact createContact(String name, String phone, String email, int contactTypeId) {
        ContactType contactType = contactTypeRepository.findById(contactTypeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ContactType with this id doesn't exist"));
        Contact contact = new Contact(name, phone, email, contactType);
        contactRepository.save(contact);
        return contact;
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
