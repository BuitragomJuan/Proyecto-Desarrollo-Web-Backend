package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.example.demo.model.usuarios.UsuarioAdmon;
import com.example.demo.model.usuarios.UsuarioAdmonRepository;

@Service
public class AutenticacionService {

    @Autowired
    private UsuarioAdmonRepository adminRepository;

    public UsuarioAdmon createAdmin(UsuarioAdmon adminDTO) {
    // Lógica para crear el administrador y guardar en la base de datos
    //UsuarioAdmon admin = new UsuarioAdmon();
    // Configurar admin con los datos de adminDTO
    return adminRepository.save(adminDTO);
  }
}
