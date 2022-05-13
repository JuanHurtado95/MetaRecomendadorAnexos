package com.ceiba.api_busqueda.controlador.adaptador.service;

import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.api_busqueda.puerto.repositorio.IConsultaApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ConsumoRestRecomendaciones implements IConsultaApi {

    @Override
    public RespApiBusqueda consultaProducto(String json) {
        
        ObjectMapper mapper = new ObjectMapper();

        String url = "http://localhost:8083/meta-recomendador/recomendacion";
        RestTemplate plantilla = new RestTemplate();
        RespApiBusqueda resultado = new RespApiBusqueda();

        try {
            JsonNode js = mapper.readTree(json);
            resultado = plantilla.postForObject(url, js, RespApiBusqueda.class);
            System.out.println(resultado.getResults());
        }catch (JsonProcessingException  e) {
            e.printStackTrace();
        }
        
        return resultado;
    }
}
