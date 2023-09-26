package com.example.demo;

import java.sql.Date;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

@Entity
@Table(
    name = "contactenos"
)
public class Contactenos {

    @Id
    private String nombre;

    private String apellido;
    private Date fecha;
    private int edad;

    public Contactenos(){
        this.nombre = null;
        this.apellido = null;
        this.fecha = null;
        this.edad = 0;
    }

    public Contactenos(String nom, String lastn, Date dat, int age){
        this.nombre = nom;
        this.apellido = lastn;
        this.fecha = dat;
        this.edad = age;
    }

    public void setNombre(String nom){
        this.nombre = nom;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setApellido(String lastn){
        this.apellido= lastn;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setValores(String nombre, String apellido, Date fecha, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.edad = edad;
    }

    public JSONObject toJSON() throws Exception {
		JSONObject japlicacion = new JSONObject();
		japlicacion.put("nombre", getNombre());
		japlicacion.put("apellido", getApellido());
		japlicacion.put("fecha", getFecha());
		japlicacion.put("edad", getEdad());
		return japlicacion;
	}

    public static JSONArray toJSONArray( Iterable<Contactenos>contactenos ) throws Exception {
		JSONArray jcontactenos = new JSONArray();
		Iterator<Contactenos> icontactenos = contactenos.iterator();
		while( icontactenos.hasNext() ) {
			Contactenos contacteno = icontactenos.next();
			jcontactenos.put( contacteno.toJSON() );
		}
		
		return jcontactenos;
	}
    
}
