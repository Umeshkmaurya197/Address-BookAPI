package com.git.addressbook.api.repository;

import com.git.addressbook.api.entity.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query(value = "Select * from address_book.contact e where e.name =:contactName",nativeQuery = true)
    Optional<Contact> findContactByName(@Param(value = "contactName") String contactName);
}
