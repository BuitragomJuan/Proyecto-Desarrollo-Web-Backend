package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Cancion;

public class ListaDto {

    private String genero;
    private List<Cancion> canciones;

    public ListaDto() {
    }

    public ListaDto(String genero, List<Cancion> canciones) {
        this.genero = genero;
        this.canciones = canciones;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }


    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    
    
}
