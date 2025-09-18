package com.roberto.rebolledo.ejercicio03.Contact;

import org.springframework.lang.Contract;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact creacteContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }

    public Contact edidtContact(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id).orElse(null);
        if (existingContact != null) {
            existingContact.setName(contact.getName());
            existingContact.setAge(contact.getAge());
            existingContact.setEmail(contact.getEmail());
            existingContact.setPhone(contact.getPhone());
            existingContact.setAddress(contact.getAddress());
            return contactRepository.save(existingContact);
        }
        return null;
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }


}
