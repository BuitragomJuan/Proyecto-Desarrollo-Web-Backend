package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UsuariovotanteRepository repo){
		return args -> {
			
			Usuariovotante usrv = new Usuariovotante();
			usrv.setId("0001");
			usrv.setNombre("JUANB");
			usrv.setCorreo("juanb01@domain.com");
			usrv.setPassword("123ABC");

			repo.save(usrv);
		};
	}

}
