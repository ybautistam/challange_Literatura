package com.proyectodosLiteratura.LiteraturaProyect.repositorio;

import com.proyectodosLiteratura.LiteraturaProyect.model.Autores;
import com.proyectodosLiteratura.LiteraturaProyect.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IRepository extends JpaRepository<Libros,Long> {

    //@Override
    @Query("SELECT l FROM Libros l WHERE l.idiomas LIKE %:idioma% ")
    List<Libros> findBYIdiomasIgnoreCase(String idioma);



}
