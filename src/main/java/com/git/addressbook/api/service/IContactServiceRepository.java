package com.git.addressbook.api.service;

import com.git.addressbook.api.dto.ContactDTO;
import com.git.addressbook.api.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IContactServiceRepository {

    Contact addContact(ContactDTO contactDTO);

    Optional<Contact> getContactById(Long contactId);

    Optional<Contact> getContactByName(String contactName);

    List<Contact> getAllContact();

    Contact updateContact(Long contactId, ContactDTO contactDTO);

    String deleteContactById(Long contactId);
}
