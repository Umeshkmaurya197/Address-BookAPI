package com.git.addressbook.api.repository;

import com.git.addressbook.api.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepositoryy extends JpaRepository<Contact,Long> {
}
