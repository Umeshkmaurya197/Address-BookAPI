package com.git.addressbook.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    public String contactName;
    public String city;
    public String address;
    public String phoneNumber;

    @Override
    public String toString() {
        return "ContactDTO{" + "name='" + contactName + '\'' + ", city='" + city + '\'' + ", address='" + address + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}';
    }
}
