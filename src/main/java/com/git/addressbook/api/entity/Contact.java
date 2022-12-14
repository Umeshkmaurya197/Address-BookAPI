package com.git.addressbook.api.entity;

import com.git.addressbook.api.dto.ContactDTO;

import javax.persistence.*;


@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id", nullable = false)
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

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return contactName;
    }

    public void setName(String contactName) {
        this.contactName = contactName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
