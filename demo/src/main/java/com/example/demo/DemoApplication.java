package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Contactenos;
import com.example.demo.model.ContactenosRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
			
	}
	
	@Bean
	CommandLineRunner commandLineRunner(ContactenosRepository contactenosRepository){
		return args -> {
			Contactenos contactenos = new Contactenos();

			contactenos.setNombre("Frank");
			contactenos.setApellido("Hernandez");
			contactenos.setFecha("2022-07-04");
			contactenos.setEdad(17);
		
			contactenosRepository.save(contactenos);
		};

		
	}

}
