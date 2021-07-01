package com.jhack.myapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jhack.myapi.Repository.UsuarioRepository;
import com.jhack.myapi.domain.Usuario;

@SpringBootApplication
public class MyApiApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyApiApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Jhack Costa", "Robemm", "1020300");
		Usuario u2 = new Usuario(null, "Tayane Dias", "Tayanee", "2030400");

		usuarioRepository.saveAll(Arrays.asList(u1, u2));
	}

}
