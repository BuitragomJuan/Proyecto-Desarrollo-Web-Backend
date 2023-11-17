package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contactenos;
import com.example.demo.model.ContactenosRepository;

@RestController
@RequestMapping("/api/contactenos")
public class ContactenosController {

    @Autowired
    private ContactenosRepository contactenosRepository;

    @GetMapping
    public ResponseEntity<List<Contactenos>> getContactenosData() {
        List<Contactenos> contactenosList = (List<Contactenos>) contactenosRepository.findAll();
        return new ResponseEntity<>(contactenosList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contactenos> saveContactenosData(@RequestBody Contactenos contactenos) {
        Contactenos newInstance = contactenosRepository.save(contactenos);
        return new ResponseEntity<>(newInstance, HttpStatus.CREATED);
    }

}