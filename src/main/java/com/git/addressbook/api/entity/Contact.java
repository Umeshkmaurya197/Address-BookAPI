package com.git.addressbook.api.entity;

import com.git.addressbook.api.dto.ContactDTO;
//import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "contact_id", nullable = false)
    private Long contactId;

    private String contactName;
    private String city;
    private String address;
    private String phoneNumber;

    public Contact() {
    }
    public Contact(ContactDTO contactDTO) {
        this.contactId = contactId;
        this.contactName = contactDTO.contactName;
        this.city = contactDTO.city;
        this.address = contactDTO.address;
        this.phoneNumber = contactDTO.phoneNumber;
    }

    public Contact(Long contactId, String contactName, String city, String address, String phoneNumber) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.city = city;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


}
