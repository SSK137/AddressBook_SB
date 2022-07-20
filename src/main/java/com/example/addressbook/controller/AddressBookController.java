package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.model.AddressBookDetails;
import com.example.addressbook.service.AddressBookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AddressBookController {
    //Make Connection With Service Class
    @Autowired
    AddressBookServiceInterface addressBookServiceInterface;

    //Add data to the Database
    @PostMapping("/postMap")
    public ResponseEntity<ResponseDTO> postData(@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBookDetails addressBookDetails=addressBookServiceInterface.addData(addressBookDTO);
        ResponseDTO responseDTO=new ResponseDTO("Record Added Successfully !!!",addressBookDetails);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Get All the Data from the Database
    @GetMapping("/getallMap")
    public ResponseEntity<ResponseDTO> getData(){
        ResponseDTO responseDTO=new ResponseDTO("Records In AddressBook ",addressBookServiceInterface.getallData());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    //Get Perticular Data by using Id number
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ResponseDTO> getDatabyId(@PathVariable int id){
        ResponseDTO responseDTO=new ResponseDTO("Details of id no. :"+id,addressBookServiceInterface.getDatabyId(id));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    //Get Perticular Data by Using City Name
    @GetMapping("/getbycity/{city}")
    public ResponseEntity<ResponseDTO> getbycity(@PathVariable String city){
        ResponseDTO responseDTO=new ResponseDTO("Details who belongs to"+city,addressBookServiceInterface.getbycityname(city));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    //Sorting all the data of database by using city name
    @GetMapping("/sortbycity")
    public ResponseEntity<ResponseDTO> sortbycity(){
        ResponseDTO responseDTO=new ResponseDTO("Sort By City Name",addressBookServiceInterface.sortbycityname());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    //Sorting all the data of database by using State name
    @GetMapping("/sortbystate")
    public ResponseEntity<ResponseDTO> sortbystate(){
        ResponseDTO responseDTO=new ResponseDTO("Sort By City Name",addressBookServiceInterface.sortbystatename());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    //Updating record of the Database by using id number
    @PutMapping("/putMap/{id}")
    public ResponseEntity<ResponseDTO> putData(@PathVariable int id,@RequestBody AddressBookDTO addressBookDTO){
        ResponseDTO responseDTO=new ResponseDTO("Record Updated Successfully !!!",addressBookServiceInterface.putData(id,addressBookDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    //Deleting particular record by using id number
    @DeleteMapping("/deleteMap/{id}")
    public ResponseEntity<ResponseDTO> deleteData(@PathVariable int id){
        ResponseDTO responseDTO=new ResponseDTO("Record of id:"+id+" Deleted Successfully",addressBookServiceInterface.deleteData(id));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
