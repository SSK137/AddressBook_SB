package com.example.addressbook.repository;

import com.example.addressbook.model.AddressBookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookDetails,Integer> {
    @Query(value = "SELECT * FROM addressbook.address_book_details where city= :city",nativeQuery = true)
    List<AddressBookDetails> getbycity(@Param("city") String city);
    @Query(value = "select * from address_book_details order by city asc",nativeQuery = true)

    List<AddressBookDetails> sortbycity();

    @Query(value = "select * from address_book_details order by state asc",nativeQuery = true)
    List<AddressBookDetails> sortbystate();
}
