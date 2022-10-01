package com.git.addressbook.api.repository;

import com.git.addressbook.api.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query(value = "Select * from address_book_1.contact e where e.full_name =:fullName", nativeQuery = true)
    List<Contact> findContactByName(@Param(value = "fullName") String fullName);
}
