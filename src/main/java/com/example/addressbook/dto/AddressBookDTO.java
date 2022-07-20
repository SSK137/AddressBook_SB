package com.example.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public @ToString class AddressBookDTO {
    @NotNull(message = "Name Must be Entered")
    @Pattern(regexp = "^([A-Z]{1}[a-z]{2,}\\s{0,1})+$",message = "Please Enter Valid Name..!!")
    private String fullName;
    @Pattern(regexp = "^[0-9]{2}\\s{0,1}[0-9]{10}$",message = "Enter Valid Phone Number")
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private Long zipcode;
}
