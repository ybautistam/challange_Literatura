package com.proyectodosLiteratura.LiteraturaProyect.repositorio;

import com.proyectodosLiteratura.LiteraturaProyect.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepositoryAutores extends JpaRepository<Autores,Long> {

    List<Autores> findBYnacimientoGreaterThan(Integer ano);
}
