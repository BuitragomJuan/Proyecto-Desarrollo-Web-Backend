package com.example.demo;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String nombre;
    private String password;
    private String id;
    private String correo;

    // Necesario para la deserialización
    public JwtRequest() {
    }

    public JwtRequest(String correo, String password) {
        this.setCorreo(correo);
        this.setPassword(password);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getCorreo(){
        return this.correo;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

}

