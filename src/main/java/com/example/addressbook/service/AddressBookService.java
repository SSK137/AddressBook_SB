package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookDetails;
import com.example.addressbook.repository.AddressBookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements AddressBookServiceInterface{
    @Autowired
    AddressBookRepository addressBookRepository;

    public AddressBookDetails addData(AddressBookDTO addressBookDTO) {
        AddressBookDetails addressBookDetails=new AddressBookDetails(addressBookDTO);
        addressBookRepository.save(addressBookDetails);
        return addressBookDetails;
    }
    public List<AddressBookDetails> getallData(){
        return addressBookRepository.findAll();
    }
    public Optional<AddressBookDetails> getDatabyId(int id){
        return addressBookRepository.findById(id);
    }
    public List<AddressBookDetails> getbycityname(String city){
        return addressBookRepository.getbycity(city);
    }
    public List<AddressBookDetails> sortbycityname(){
        return addressBookRepository.sortbycity();
    }
    public List<AddressBookDetails> sortbystatename(){
        return addressBookRepository.sortbystate();
    }
    public AddressBookDetails putData(int id, AddressBookDTO addressBookDTO){
        AddressBookDetails addressBookDetails=new AddressBookDetails(id,addressBookDTO);
        addressBookRepository.save(addressBookDetails);
        return addressBookDetails;
    }
    public String deleteData(int id){
        addressBookRepository.deleteById(id);
        return "*********** You can add new Data *************";
    }
}
