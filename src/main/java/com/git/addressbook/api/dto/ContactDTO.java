package com.git.addressbook.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name should start with capital letter and have minimum 3 characters. ")
    public String fullName;
    public String phoneNumber;
    public String address;
    public String city;
    public String state;
    public Integer zip;

    @Override
    public String toString() {
        return "ContactDTO{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}
