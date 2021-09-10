package com.example.phonebook.repository;

import com.example.phonebook.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {
}
