package com.proyectodosLiteratura.LiteraturaProyect.Conexion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class pasarDatosApi implements IpasarDatosApi {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T conexionApi(String json , Class<T> clase){
        try{
            return mapper.readValue(json,clase);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }





}
