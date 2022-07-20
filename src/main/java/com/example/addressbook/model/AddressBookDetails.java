package com.example.addressbook.model;

import com.example.addressbook.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AddressBookDetails {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    private String fullName;
    private @Pattern(regexp = "^[0-9]{2}\\s{0,1}[0-9]{10}$") String phoneNumber;
    private String address;
    private String city;
    private String state;
    double zipcode;

    public AddressBookDetails(AddressBookDTO addressBookDTO) {
        this.fullName=addressBookDTO.getFullName();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.address=addressBookDTO.getAddress();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zipcode=addressBookDTO.getZipcode();
    }

    public AddressBookDetails(int id, AddressBookDTO addressBookDTO) {
        this.id=id;
        this.fullName=addressBookDTO.getFullName();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.address=addressBookDTO.getAddress();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zipcode=addressBookDTO.getZipcode();
    }
}
