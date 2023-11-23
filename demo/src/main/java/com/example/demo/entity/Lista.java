package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Lista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String genero;

    @JsonBackReference
     @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cancion> canciones = new ArrayList<>();;


    public Lista(){

    }
    

    public Lista(String genero, List<Cancion> canciones) {
        this.genero = genero;
        this.canciones = canciones;
    }


    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setGenero(String genre){
        this.genero = genre;
    }

    public String getGenero(){
        return this.genero;
    }


    public List<Cancion> getCanciones() {
        return canciones;
    }


    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

}
