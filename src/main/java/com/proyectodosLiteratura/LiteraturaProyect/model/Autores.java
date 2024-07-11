package com.proyectodosLiteratura.LiteraturaProyect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nombreAutor;
    private Integer nacimiento;
    private Integer fallecimiento;
    private String titulolibro;

    public Autores(datosAutores datosautores){
        this.nombreAutor = datosautores.nombreAutor();
        this.titulolibro = datosautores.titulolibros();
        this.nacimiento = datosautores.nacimiento();
        this.fallecimiento = datosautores.fallecimiento();


    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(Integer fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public String getTitulolibro() {
        return titulolibro;
    }

    public void setTitulolibro(String titulolibro) {
        this.titulolibro = titulolibro;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return " *****Autores******" +
                "   nombreAutor='" + nombreAutor + '\'' +
                ", nacimiento=" + nacimiento +
                ", fallecimiento=" + fallecimiento +
                ", titulolibro='" + titulolibro + '\'';
    }
}
