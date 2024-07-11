package com.proyectodosLiteratura.LiteraturaProyect.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record datosLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("name") String autorLibro,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Integer descargas




) {
}
