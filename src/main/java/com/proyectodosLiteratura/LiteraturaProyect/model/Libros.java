package com.proyectodosLiteratura.LiteraturaProyect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Libros")

public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)


    private String titulo;
    private String autorLibro;
    private String idiomas;
    private Integer descargas;


    public Libros(datosLibros datoslibros){
        this.titulo = datoslibros.titulo();
        this.autorLibro = datoslibros.autorLibro();
        this.idiomas = String.valueOf(datoslibros.idiomas());
        this.descargas = datoslibros.descargas();


    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "Libros{"
                +
                "Id=" + Id +
                ", titulo='" + titulo + '\'' +
                ", autorLibro='" + autorLibro + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", descargas=" + descargas;
    }
}
