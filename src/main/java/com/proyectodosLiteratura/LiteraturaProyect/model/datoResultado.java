package com.proyectodosLiteratura.LiteraturaProyect.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record datoResultado(
        @JsonAlias("results")List<datosLibros> resultado,

        @JsonAlias("authors") List<datosAutores> resultadoAutores



        ) {
}
