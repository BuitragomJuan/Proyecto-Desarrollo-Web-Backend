package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Listas;
import com.example.demo.model.ListasRepository;

@Controller
public class ListasController {

    @Autowired
    private ListasRepository lrepository;
    
    @GetMapping("/listas")
    public String showForm(Model model) {
        model.addAttribute("listas", new Listas());
        return "";
    }
    
    @PostMapping("/listas")
    public String saveData(@ModelAttribute Listas lista) {

        lrepository.save(lista);
        return "redirect:/";
    }
    
}
