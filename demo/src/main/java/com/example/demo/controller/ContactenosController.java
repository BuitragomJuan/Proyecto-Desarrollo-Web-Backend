package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contactenos;
import com.example.demo.model.ContactenosRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ContactenosController {

    @Autowired
    private ContactenosRepository contactenosRepository;

    // This method responds to GET requests to "/api/contactenos"
    @GetMapping("/contactenos")
    public ResponseEntity<List<Contactenos>> getContactenosData() {
        List<Contactenos> contactenosList = (List<Contactenos>) contactenosRepository.findAll();
        return ResponseEntity.ok(contactenosList);
    }

    // This method responds to POST requests to "/api/contactenos"
    @PostMapping("/contactenos")
    public ResponseEntity<String> saveContactenosData(@RequestBody Contactenos contactenos) {
        contactenosRepository.save(contactenos);
        return ResponseEntity.ok("Data saved successfully");
    }

    /*@GetMapping("/proyecto")
    public String showProyecto() {
        return "proyecto";
    }

    @GetMapping("/equipo")
    public String showTeam() {
        return "equipo";
    }


    @GetMapping("/")
    public String showHome() {
        return "homepage";
    }

    @GetMapping("/contactenos")
    public String showForm(Model model) {
        model.addAttribute("contactenos", new Contactenos());
        return "contactenos";
    }
    
    @PostMapping("/contactenos")
    public String saveData(@ModelAttribute Contactenos contactenos) {

        contactenosRepository.save(contactenos);
        return "redirect:/contactenos";
    } */
}
