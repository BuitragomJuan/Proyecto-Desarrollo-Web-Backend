package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name="cancion"
)
public class Cancion {

    @Id
    @Column(
        name= "ID",
        nullable = false,
        columnDefinition = "Text"
    )
    private String ID;

    @Column(
        name="nombre",
        nullable = false,
        columnDefinition = "Text"
    )
    private String nombre;

    @Column(
        name="genero",
        columnDefinition = "Text"
    )
    private String genero;

    @Column(
        name="rating",
        nullable = false,
        columnDefinition = "Text"
    )
    private int rating;

    @Column(
        name="artista",
        nullable = false,
        columnDefinition = "Text"
    )
    private String artista;

    @Column(
        name="album",
        columnDefinition = "Text"
    )
    private String album;

    public void setId(String id){
        this.ID = id;
    }

    public String getId(){
        return this.ID;
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
    
}
