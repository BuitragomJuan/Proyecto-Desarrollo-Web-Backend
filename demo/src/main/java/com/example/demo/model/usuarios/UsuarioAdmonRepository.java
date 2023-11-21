package com.example.demo.model.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAdmonRepository extends JpaRepository<UsuarioAdmon,String>{

    UsuarioAdmon findByNombre(String nombre);
    
}
