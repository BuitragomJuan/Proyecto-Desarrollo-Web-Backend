package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.AutenticacionService;
import com.example.demo.JwtRequest;
import com.example.demo.JwtResponse;
import com.example.demo.JwtTokenUtil;
import com.example.demo.MyUserDetailsService;
import com.example.demo.model.usuarios.UsuarioAdmon;
//import com.example.demo.model.usuarios.UsuarioAdmon;
import com.example.demo.model.usuarios.UsuarioAdmonRepository;
import com.example.demo.model.usuarios.Usuariovotante;
import com.example.demo.model.usuarios.UsuariovotanteRepository;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UsuarioAdmonRepository administradorRepository;

    /*@Autowired
    private AutenticacionService authService; */

    @Autowired
    private UsuariovotanteRepository votanteRepository;

     @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        
        try{
            // Autenticar al usuario
            final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getCorreo(), authenticationRequest.getPassword())
            );

            // Generar token JWT
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getCorreo());
            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token, userDetails.getUsername()));
        }catch(BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("credenciales invalidas");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @PostMapping("/admin/registro")
    public ResponseEntity<?> signUpAdministrador(@RequestBody UsuarioAdmon adminUser) {
        // Verificar si el nombre de usuario ya está registrado
        if (administradorRepository.findByCorreo(adminUser.getCorreo()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de usuario ya está registrado");
        }

        //UsuarioAdmon registeredUser = authService.createAdmin(adminUser);
        administradorRepository.save(adminUser);
        //return ResponseEntity.ok("Usuario administrador registrado exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");

        // Lógica para registrar Administrador
        //UsuarioAdmon nuevoAdministrador = new UsuarioAdmon();
        //nuevoAdministrador.setNombre(authenticationRequest.getUsername());
        //nuevoAdministrador.setPassword(authenticationRequest.getPassword());

        //administradorRepository.save(nuevoAdministrador);

        //String token = jwtTokenUtil.generateToken(adminUser.getNombre());
        //return ResponseEntity.status(HttpStatus.CREATED).body("Administrador registrado exitosamente");
        //return ResponseEntity.ok(new JwtResponse(token, token));
    }

    @PostMapping("/votante/registro")
    public ResponseEntity<?> signUpVotante(@RequestBody JwtRequest authenticationRequest) {
        // Verificar si el nombre de usuario ya está registrado
        if (votanteRepository.findByCorreo(authenticationRequest.getNombre()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de usuario ya está registrado");
        }

        // Lógica para registrar Votante
        Usuariovotante nuevoVotante = new Usuariovotante();
        nuevoVotante.setNombre(authenticationRequest.getNombre());
        nuevoVotante.setPassword(authenticationRequest.getPassword());
        nuevoVotante.setId(authenticationRequest.getId());
        nuevoVotante.setCorreo(authenticationRequest.getCorreo());

        votanteRepository.save(nuevoVotante);

        return ResponseEntity.status(HttpStatus.CREATED).body("Votante registrado exitosamente");
    }
}

