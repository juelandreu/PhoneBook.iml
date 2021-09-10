package com.example.phonebook.controller;

import com.example.phonebook.model.PhoneBook;
import com.example.phonebook.service.PhoneBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/phonebook")
public class PhoneBookController {
    private PhoneBookService phoneBookService;

    @GetMapping
    public ResponseEntity<List<PhoneBook>> getAll() {
        return new ResponseEntity(phoneBookService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PhoneBook> addPhoneNumber(@Valid @RequestBody PhoneBook phoneBook) {
        return new ResponseEntity(phoneBookService.addPhoneNumber(phoneBook), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<PhoneBook> editPhoneNumber(@Valid @RequestBody PhoneBook phoneBook) {
        return new ResponseEntity(phoneBookService.editPhoneNumber(phoneBook), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void deletePhoneNumber(@PathVariable Long id) {
        phoneBookService.deletePhoneNumber(id);
    }
}
