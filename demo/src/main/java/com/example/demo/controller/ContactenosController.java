package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Contactenos;
import com.example.demo.model.ContactenosRepository;

@Controller
public class ContactenosController {

    @Autowired
    private ContactenosRepository contactenosRepository;

    
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
    }
}
