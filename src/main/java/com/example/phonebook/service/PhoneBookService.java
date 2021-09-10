package com.example.phonebook.service;

import com.example.phonebook.model.PhoneBook;
import com.example.phonebook.repository.PhoneBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PhoneBookService {

    private final PhoneBookRepository phoneBookRepository;

    public List<PhoneBook> getAll(){
        return phoneBookRepository.findAll(Sort.by("firstname").ascending());
    }

    public PhoneBook addPhoneNumber(PhoneBook phoneBook){
            return phoneBookRepository.save(phoneBook);
    }

    public void deletePhoneNumber(Long id){
        Optional<PhoneBook> existingElement = phoneBookRepository.findById(id);
        if (existingElement.isEmpty()) {
            throw new RuntimeException("Cannot find phone number with id: " + id);
        } else {
            phoneBookRepository.delete(existingElement.get());
        }
    }
    public PhoneBook editPhoneNumber(PhoneBook phoneBook){
        Optional<PhoneBook> existingElement = phoneBookRepository.findById(phoneBook.getId());
        if (existingElement.isEmpty()) {
            throw new RuntimeException("Number does not exists");
        } else {
            PhoneBook obj = existingElement.get();
            BeanUtils.copyProperties(phoneBook, obj);
            return phoneBookRepository.save(obj);
        }
    }

}
