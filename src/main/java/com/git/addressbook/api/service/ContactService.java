package com.git.addressbook.api.service;

import com.git.addressbook.api.dto.ContactDTO;
import com.git.addressbook.api.entity.Contact;
import com.git.addressbook.api.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactServiceRepository {

    @Autowired
    ContactRepository contactRepository;
    @Override
    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO);
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> getContactById(Long contactId) {
        Optional<Contact> contact = contactRepository.findById(contactId);
        return contact;
    }

    @Override
    public Optional<Contact> getContactByName(String contactName) {
        return contactRepository.findContactByName(contactName);
    }


    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact updateContact(Long contactId, ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO);
        contact.setContactId(contactId);
        return contact;
    }

    @Override
    public String deleteContactById(Long contactId) {
        contactRepository.deleteById(contactId);
        return "contact deleted Successfully";
    }
}
