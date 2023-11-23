package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.example.demo.entity.Cancion;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class ListaDto {

    private String genero;
    private List<CancionDto> canciones = new ArrayList<>();

    public ListaDto() {
    }

    public ListaDto(String genero, List<CancionDto> canciones) {
        this.genero = genero;
        this.canciones = canciones;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<CancionDto> getCanciones() {
        return canciones;
    }


    public void setCanciones(List<CancionDto> canciones) {
        this.canciones = canciones;
    }

    
    
}
