package com.example.demo.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.entity.Lista;

public class CancionDto {

    private String nombre;
    private String genero;
    private int rating;
    private String artista;
    private String album;
    private Long gen_id;

    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    public CancionDto() {
    }

    public CancionDto(String nombre, String genero, int rating, String artista, String album, Long gen_id, Lista lista) {
        this.nombre = nombre;
        this.genero = genero;
        this.rating = rating;
        this.artista = artista;
        this.album = album;
        this.gen_id = gen_id;
        this.lista = lista;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    
    public Long getGen_id() {
        return gen_id;
    }

    public void setGen_id(Long gen_id) {
        this.gen_id = gen_id;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
    
}
