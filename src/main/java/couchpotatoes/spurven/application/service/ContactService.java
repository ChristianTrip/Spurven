package couchpotatoes.spurven.application.service;


import couchpotatoes.spurven.application.entity.Contact;
import couchpotatoes.spurven.application.repository.ContactRepository;
import org.springframework.stereotype.Service;

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
        return contactRepository.findById(id).orElse(null);
    }
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }
    public Contact editContact(Contact contact) {
        return contactRepository.save(contact);
    }
    public Contact deleteContact(int id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()){
            contactRepository.delete(contact.get());
        }
        return contact.orElse(null);
    }
}
