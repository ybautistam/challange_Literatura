package com.proyectodosLiteratura.LiteraturaProyect.principal;

import com.proyectodosLiteratura.LiteraturaProyect.Conexion.ConsultaApi;
import com.proyectodosLiteratura.LiteraturaProyect.Conexion.pasarDatosApi;
import com.proyectodosLiteratura.LiteraturaProyect.model.*;
import com.proyectodosLiteratura.LiteraturaProyect.repositorio.IRepository;
import com.proyectodosLiteratura.LiteraturaProyect.repositorio.IRepositoryAutores;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

private ConsultaApi consultaApi = new ConsultaApi();
private Scanner teclado = new Scanner(System.in);
private pasarDatosApi convertirDatos = new pasarDatosApi();
private final String URL_API = "https://gutendex.com/books/";

private List<datosLibros> datoslibro = new ArrayList<>();
private List<Libros> libro = new ArrayList<>();
private IRepository repositorio;
private IRepositoryAutores repositoryautores;

public  Principal(IRepository repositorio, IRepositoryAutores repositoryAutores){
    this.repositorio = repositorio;
    this.repositoryautores = repositoryAutores;
}

public void menuprincipal(){

    System.out.println("*********Bienvenid@ a nuestro sitema de busqueda y consulta de Libros y Autores ***********");
    int opcion;

    do {
        System.out.println("Aqui te muestro algunas opciones que desees Consultar :) : ");
        System.out.println("""
                1 - Busqueda de libros por Nombre del titulo
                2 - Lista de Todos los Libros
                3 - Busqueda de Autores 
                4 - Lista autores vivos en Determinado Año
                5 - Lista de Libros por Idiomas (Idiomas disponibles ingles y espanol)
                6 - Top 10 Libros mas Descargados 
                0 - Salir del programa
                """);
        opcion = teclado.nextInt();
        teclado.nextLine();

        switch (opcion){
            case 1:
                BusquedaLibroPorTitulo();
                break;
            case 2:
                listaDeLibro();
                break;
            case 3:
                busquedaDeAutores();
                break;
            case 4:
                listaDeAutoresPorAnio();
                break;
            case 5:
                listaPorIdioma();
                break;
            case 6:
                top10Libros();
                break;

            case 0:
                System.out.println("Aqui nos Despedimos :( , !Hasta Pronto ...  ");
                System.out.println("Seccion Cerrada");
                break;


            default:
                System.out.println("opcion invalida...");



        }


    }while(opcion != 0);

}

private void BusquedaLibroPorTitulo(){
    //Busqueda de libros por Nombre del titulo
    System.out.println("Ingresa el nombre por titulo que desees buscar :");
    var obtenertitulo = teclado.nextLine();

    var json = consultaApi.conexionApi(URL_API + "?search" + obtenertitulo.replace(" " , " + "));
    var consulta = convertirDatos.conexionApi(json, datoResultado.class);
    Optional<datosLibros> obtenerInformacion = consulta.resultado().stream()
            .filter(l -> l.titulo().toUpperCase().contains(obtenertitulo.toUpperCase()))
            .findFirst();
    if (obtenerInformacion.isPresent()){
        System.out.println("Aqui tiene la informacion de tu busquedad: ");
        System.out.println(obtenerInformacion.get());
    }else {
        System.out.println("no pude encontrar tu libro,Busca otro");
    }

}


private void listaDeLibro(){
    System.out.println("***** Mostrando Historial de Busquedad ******");
    libro = repositorio.findAll();  // findAll recupera todos los registros que estan en la tabla

    if(libro.isEmpty()){
        System.out.println("no tienes Historial de libros Aqui");
    }else {
        libro.stream()
                .map(Libros::toString)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}

private void busquedaDeAutores(){
    System.out.println("ingresa el nombre del Autor que quieres Buscar: ");
    var nombreAutor = teclado.nextLine();

    var json = consultaApi.conexionApi(URL_API + "?search" + nombreAutor.replace(" ", "+"));
    var consulta = convertirDatos.conexionApi(json, datoResultado.class);
    Optional<datosAutores> buscaquedaAutores = consulta.resultadoAutores().stream()
            .filter(a->a.nombreAutor().toLowerCase().contains(nombreAutor.toUpperCase()))
            .findFirst();
    if(buscaquedaAutores.isPresent()){
        System.out.println("Resultado de la busqueda");
        System.out.println(buscaquedaAutores.get());;
    }else {
        System.out.println("autor no encontrado");
    }

}

private void listaDeAutoresPorAnio(){
    System.out.println("ingresa el año del autor que estas buscando: ");
    var anio = teclado.nextInt();
    teclado.nextLine();
    List<Autores> autores = repositoryautores.findBYnacimientoGreaterThan(anio);
    autores.stream()
            .forEach(System.out::println);

}

private void listaPorIdioma(){
    System.out.println("""
            Selecciona una de los dos idiomas en el que quiere encontra tu libro : 
            
            1) En - Ingles
            
            2) Es - Espanol
            
            """);
    var idioma = teclado.nextLine();
    libro = repositorio.findBYIdiomasIgnoreCase(idioma);
    libro.stream()
            .forEach(System.out::println);

}

private void top10Libros(){

    System.out.println("***** Top 10 libros mas descargados *****");
    var json = consultaApi.conexionApi(URL_API);
    System.out.println(json);
    var datos = convertirDatos.conexionApi(json,datoResultado.class);
    System.out.println(datos);

    datos.resultado().stream()
            .sorted(Comparator.comparing(datosLibros::descargas).reversed())
            .limit(10)
            .map(l -> l.titulo().toUpperCase())
            .forEach(System.out::println);


}





}
