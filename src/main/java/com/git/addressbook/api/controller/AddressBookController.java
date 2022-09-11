package com.git.addressbook.api.controller;

import com.git.addressbook.api.dto.ContactDTO;
import com.git.addressbook.api.dto.ResponseDTO;
import com.git.addressbook.api.service.IContactServiceRepository;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    IContactServiceRepository contactServiceRepository;

    @PostMapping("/addcontact")
    public ResponseEntity<ResponseDTO> addContact( @RequestBody ContactDTO contactDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Contact created successfully", contactServiceRepository.addContact(contactDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getcontact/{contactId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable Long contactId) {
        ResponseDTO responseDTO = new ResponseDTO("Based on contact id " + contactId + " found data ", contactServiceRepository.getContactById(contactId));
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    @GetMapping("/getcontact/{contactName}")
    public ResponseEntity<ResponseDTO> getContactByName(@PathVariable String contactName){
        ResponseDTO responseDTO = new ResponseDTO("Based on Contact Name "+contactName+" found data",contactServiceRepository.getContactByName(contactName));
        return new ResponseEntity<>(responseDTO,HttpStatus.FOUND);
    }

    @PutMapping("/updatecontact/{contactId}")
    public ResponseEntity<ResponseDTO> updateContactById(@PathVariable Long contactId,@RequestBody ContactDTO contactDTO){
        ResponseDTO responseDTO = new ResponseDTO("Based on contact id "+contactId+" contact updated",contactServiceRepository.updateContact(contactId,contactDTO));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/deletecontact/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContactById(@PathVariable Long contactId){
        ResponseDTO responseDTO = new ResponseDTO("Based on contact id "+contactId+"contact deleted ",contactServiceRepository.deleteContactById(contactId));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
