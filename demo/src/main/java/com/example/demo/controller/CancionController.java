package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Cancion;
import com.example.demo.model.CancionRepository;

@Controller
public class CancionController {

    @Autowired
    private CancionRepository cRepository;
    
    @GetMapping("/cancion")
    public String showForm(Model model) {
        model.addAttribute("cancion", new Cancion());
        return "";
    }
    
    @PostMapping("/cancion")
    public String saveData(@ModelAttribute Cancion cancion) {

        cRepository.save(cancion);
        return "redirect:/";
    }
    
}
