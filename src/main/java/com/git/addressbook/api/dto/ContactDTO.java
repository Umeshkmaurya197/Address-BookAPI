package com.git.addressbook.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name should start with capital letter and have minimum 3 characters. ")
    public String contactName;
    public String city;
    public String address;
    public String phoneNumber;
    @Email
    public String email;

    @Override
    public String toString() {
        return "ContactDTO{" + "name='" + contactName + '\'' + ", city='" + city + '\'' + ", address='" + address + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}';
    }
}
