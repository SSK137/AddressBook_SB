package com.example.addressbook.exception;

public class AddressBookExceptionHandler extends RuntimeException {
    public AddressBookExceptionHandler(String message){
        super(message);
    }
}
