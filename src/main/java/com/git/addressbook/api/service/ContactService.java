package com.git.addressbook.api.service;

import com.git.addressbook.api.dto.ContactDTO;
import com.git.addressbook.api.entity.Contact;
import com.git.addressbook.api.exception.CustomException;
import com.git.addressbook.api.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    EmailService emailService;

    @Override
    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO);
        contactRepository.save(contact);
//        emailService.sendMail(contactDTO.getEmail(), "Contact Created Successfully in address book ", "your Contact Now Saved in the AddressBook ");
        return contact;
    }

    @Override
    public Optional<Contact> getContactById(Long contactId) {
        Optional<Contact> contact = contactRepository.findById(contactId);
        if (contact.isPresent()) return contact;
        else throw new CustomException(" Employee id not exist ");
    }

    @Override
    public List<Contact> getContactByName(String fullName) {
        List<Contact> contactList = contactRepository.findContactByName(fullName);
        if (contactList.isEmpty()) {
            throw new CustomException("Employee name " + fullName + " not found in list ");
        } else {
            return contactList;
        }
    }


    @Override
    public List<Contact> getAllContact() {
        List<Contact> contactList = contactRepository.findAll();
        if (contactList.isEmpty()) {
            throw new CustomException("List is Empty");
        } else {
            return contactList;
        }
    }

    @Override
    public Contact updateContact(Long contactId, ContactDTO contactDTO) {
        Optional<Contact> contactData = contactRepository.findById(contactId);
        if (contactData.isPresent()) {
            Contact contact = new Contact(contactDTO);
            contact.setContactId(contactId);
            return contactRepository.save(contact);
        } else {
            throw new CustomException("Employee id not exit ");
        }
    }

    @Override
    public String deleteContactById(Long contactId) {
        Optional<Contact> contact = contactRepository.findById(contactId);
        if (contact.isPresent()) { 
            contactRepository.deleteById(contactId);
            return "contact deleted Successfully";
        } else {
            throw new CustomException("Employee id not exist");
        }
    }
}
