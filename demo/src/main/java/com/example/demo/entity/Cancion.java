package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;
    private String genero;
    private int rating;
    private String artista;
    private String album;
    private Long gen_id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    

    public Cancion() {
    }

    public Cancion(String nombre, String genero, int rating, String artista, String album, Long gen_id, Lista lista) {
        this.nombre = nombre;
        this.genero = genero;
        this.rating = rating;
        this.artista = artista;
        this.album = album;
        this.gen_id = gen_id;
        this.lista = lista;
    }

    

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setNombre(String nom){
        this.nombre= nom;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setGenero(String genre){
        this.genero= genre;
    }

    public String getGenero(){
        return this.genero;
    }

    public void setRating(int rat){
        this.rating = rat;
    }

    public int getRating(){
        return this.rating;
    }

    public void setArtista(String art){
        this.artista = art;
    }

    public String getArtista(){
        return this.artista;
    }

    public void setAlbum(String alb){
        this.album = alb;
    }

    public String getAlbum(){
        return this.album;
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
