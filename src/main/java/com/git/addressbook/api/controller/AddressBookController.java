package com.git.addressbook.api.controller;

import com.git.addressbook.api.dto.ContactDTO;
import com.git.addressbook.api.dto.ResponseDTO;
import com.git.addressbook.api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/address-book")
public class AddressBookController {

    @Autowired
    ContactService contactServiceRepository;

    //Curl - http://localhost:8080/address-book/add-contact
    @PostMapping("/add-contact")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody ContactDTO contactDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Contact created successfully", contactServiceRepository.addContact(contactDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //Curl - http://localhost:8080/address-book/get-contact/2
    @GetMapping("/get-contact/{contactId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable Long contactId) {
        ResponseDTO responseDTO = new ResponseDTO("Based on contact id " + contactId + " found data ", contactServiceRepository.getContactById(contactId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Curl - http://localhost:8080/address-book/get-all-contacts
    @GetMapping("/get-all-contacts")
    public ResponseEntity<ResponseDTO> getAllContacts() {
        ResponseDTO responseDTO = new ResponseDTO("Based on request found data ", contactServiceRepository.getAllContact());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Curl - http://localhost:8080/address-book/get-contact-by-name/Lucifer Morning Star
    @GetMapping("/get-contact-by-name/{fullName}")
    public ResponseEntity<ResponseDTO> getContactByName(@PathVariable String fullName) {
        ResponseDTO responseDTO = new ResponseDTO("Based on Contact Name " + fullName + " found data", contactServiceRepository.getContactByName(fullName));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Curl - http://localhost:8080/address-book/update-contact/1
    @PutMapping("/update-contact/{contactId}")
    public ResponseEntity<ResponseDTO> updateContactById(@PathVariable Long contactId, @RequestBody ContactDTO contactDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Based on contact id " + contactId + " contact updated", contactServiceRepository.updateContact(contactId, contactDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //Curl - http://localhost:8080/address-book/delete-contact/2
    @DeleteMapping("/delete-contact/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContactById(@PathVariable Long contactId) {
        ResponseDTO responseDTO = new ResponseDTO("Based on contact id " + contactId + "contact deleted ", contactServiceRepository.deleteContactById(contactId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
