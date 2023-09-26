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

			contactenos.setNombre("juan");
			contactenos.setApellido("Buitrago");
			contactenos.setFecha("2023-12-12");
			contactenos.setEdad(20);
		
			contactenosRepository.save(contactenos);
		};

		
	} 

}
