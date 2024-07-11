package com.proyectodosLiteratura.LiteraturaProyect;

import com.proyectodosLiteratura.LiteraturaProyect.principal.Principal;
import com.proyectodosLiteratura.LiteraturaProyect.repositorio.IRepository;
import com.proyectodosLiteratura.LiteraturaProyect.repositorio.IRepositoryAutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaProyectApplication implements CommandLineRunner {

	@Autowired
	private IRepository repositorio;
	@Autowired
	private IRepositoryAutores repositoryAutores;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaProyectApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio,repositoryAutores);
		principal.menuprincipal();
	}
}
