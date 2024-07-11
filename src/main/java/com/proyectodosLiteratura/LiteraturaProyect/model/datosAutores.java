package com.proyectodosLiteratura.LiteraturaProyect.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record datosAutores(
        @JsonAlias("name") String nombreAutor,
        @JsonAlias("title") String titulolibros,
        @JsonAlias("birth_year") Integer nacimiento,
        @JsonAlias("death_year") Integer fallecimiento

) {

}
