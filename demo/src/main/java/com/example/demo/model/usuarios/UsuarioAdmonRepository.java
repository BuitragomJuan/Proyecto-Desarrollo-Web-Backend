package com.example.demo.model.usuarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAdmonRepository extends CrudRepository<UsuarioAdmon,String>{

    UsuarioAdmon findByNombreUsuarioAdmon(String nombre);
    
}
