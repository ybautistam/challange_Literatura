package com.proyectodosLiteratura.LiteraturaProyect.Conexion;

public interface IpasarDatosApi {
     <T> T conexionApi(String json,Class<T> clase);
}
