package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "lista"
)
public class Listas {
    
    @Id
    @Column(
        name = "ID",
        nullable = false,
        columnDefinition = "Text"
    )
    private String ID;
    @Column(
        name = "genero",
        nullable = false,
        columnDefinition = "Text"
    )
    private String genero;


    public Listas(){

    }

    public void setValues(String id, String genero){
        this.ID = id;
        this.genero = genero;
    }


    public void setId(String id){
        this.ID = id;
    }

    public String getId(){
        return this.ID;
    }

    public void setGenero(String genre){
        this.genero = genre;
    }

    public String getGenero(){
        return this.genero;
    }

}
