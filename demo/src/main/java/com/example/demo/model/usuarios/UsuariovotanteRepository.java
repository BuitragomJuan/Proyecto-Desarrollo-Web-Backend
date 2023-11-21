package com.example.demo.model.usuarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariovotanteRepository extends CrudRepository<Usuariovotante,String>{

    Usuariovotante findByCorreo(String correo);

}