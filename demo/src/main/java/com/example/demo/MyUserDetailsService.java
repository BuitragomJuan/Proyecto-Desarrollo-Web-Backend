package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.usuarios.UsuarioAdmon;
import com.example.demo.model.usuarios.UsuarioAdmonRepository;
import com.example.demo.model.usuarios.Usuariovotante;
import com.example.demo.model.usuarios.UsuariovotanteRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioAdmonRepository adminRepository;
    private UsuariovotanteRepository votanteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         // Intenta cargar el usuario como Administrador
         UsuarioAdmon administrador = adminRepository.findByNombre(username);
         if (administrador != null) {
             return User.builder()
                     .username(administrador.getNombre())
                     .password(administrador.getPassword())
                     .roles("ROLE_ADMIN")  // Puedes ajustar los roles según tus necesidades
                     .build();
         }
 
         // Si no es un Administrador, intenta cargar el usuario como Votante
         Usuariovotante votante = votanteRepository.findByNombre(username);
         if (votante != null) {
             return User.builder()
                     .username(votante.getNombre())
                     .password(votante.getPassword())
                     .roles("ROLE_USER")  // Puedes ajustar los roles según tus necesidades
                     .build();
         }
 
         // Si no se encuentra el usuario, lanza una excepción
         throw new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username);
    }
}
