package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JwtRequest;
import com.example.demo.JwtResponse;
import com.example.demo.JwtTokenUtil;
import com.example.demo.MyUserDetailsService;
import com.example.demo.model.usuarios.UsuarioAdmon;
import com.example.demo.model.usuarios.UsuarioAdmonRepository;
import com.example.demo.model.usuarios.Usuariovotante;
import com.example.demo.model.usuarios.UsuariovotanteRepository;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UsuarioAdmonRepository administradorRepository;

    @Autowired
    private UsuariovotanteRepository votanteRepository;

     @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        // Autenticar al usuario
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        // Generar token JWT
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token, token));
    }

    @PostMapping("/signup/administrador")
    public ResponseEntity<?> signUpAdministrador(@RequestBody JwtRequest authenticationRequest) {
        // Verificar si el nombre de usuario ya está registrado
        if (administradorRepository.findByNombreUsuarioAdmon(authenticationRequest.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de usuario ya está registrado");
        }

        // Lógica para registrar Administrador
        UsuarioAdmon nuevoAdministrador = new UsuarioAdmon();
        nuevoAdministrador.setNombre(authenticationRequest.getUsername());
        nuevoAdministrador.setPassword(authenticationRequest.getPassword());

        administradorRepository.save(nuevoAdministrador);

        return ResponseEntity.status(HttpStatus.CREATED).body("Administrador registrado exitosamente");
    }

    @PostMapping("/signup/votante")
    public ResponseEntity<?> signUpVotante(@RequestBody JwtRequest authenticationRequest) {
        // Verificar si el nombre de usuario ya está registrado
        if (votanteRepository.findByNombreUsuariovotante(authenticationRequest.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de usuario ya está registrado");
        }

        // Lógica para registrar Votante
        Usuariovotante nuevoVotante = new Usuariovotante();
        nuevoVotante.setNombre(authenticationRequest.getUsername());
        nuevoVotante.setPassword(authenticationRequest.getPassword());

        votanteRepository.save(nuevoVotante);

        return ResponseEntity.status(HttpStatus.CREATED).body("Votante registrado exitosamente");
    }
}

