package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookDetails;

import java.util.List;
import java.util.Optional;

public interface AddressBookServiceInterface {
    AddressBookDetails addData(AddressBookDTO addressBookDTO);

    List<AddressBookDetails> getallData();

    AddressBookDetails putData(int id, AddressBookDTO addressBookDTO);

    Optional<AddressBookDetails> getDatabyId(int id);

    String deleteData(int id);

    List<AddressBookDetails> getbycityname(String city);
    List<AddressBookDetails> sortbycityname();
    List<AddressBookDetails> sortbystatename();
}
