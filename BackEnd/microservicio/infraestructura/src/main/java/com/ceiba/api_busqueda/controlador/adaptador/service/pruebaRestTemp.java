package com.ceiba.api_busqueda.controlador.adaptador.service;

import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.busqueda.modelo.entidad.BusquedaAlmacenada;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.ceiba.api_busqueda.puerto.repositorio.IConsumoApi;

@Repository
public class pruebaRestTemp implements IConsumoApi {

    private final String MERCADOLIBRECOLOMBIA = "MCO";
    private final String MERCADOLIBREECUADOR = "MEC";

    @Override
    public RespApiBusqueda crearBusquedaMCO(String palabra, int limite) {
        String url = "https://api.mercadolibre.com/sites/"+MERCADOLIBRECOLOMBIA+"/search?q="+palabra+"&limit="+limite;
        RestTemplate plantilla = new RestTemplate();
        RespApiBusqueda resultado = plantilla.getForObject(url, RespApiBusqueda.class);
        return resultado;
    }

    @Override
    public RespApiBusqueda crearBusquedaMEC(String palabra, int limite) {
        String url = "https://api.mercadolibre.com/sites/"+MERCADOLIBREECUADOR+"/search?q="+palabra+"&limit="+limite;
        RestTemplate plantilla = new RestTemplate();
        RespApiBusqueda resultado = plantilla.getForObject(url, RespApiBusqueda.class);
        return resultado;
    }

    @Override
    public String almacenarBusqueda(BusquedaAlmacenada busquedaAlmacenada) {

        String palabra = busquedaAlmacenada.getPalabraBuscada();
        String [] separadas = palabra.split(" ");
        BusquedaAlmacenada primerPalabra = new BusquedaAlmacenada(0L, busquedaAlmacenada.getIdUsuario(), separadas[0], "");
        System.out.println(separadas[0]);

        String url = "http://localhost:8083/meta-recomendador/busquedas";
        RestTemplate plantilla = new RestTemplate();
        String result = plantilla.postForObject(url, busquedaAlmacenada, String.class);
        palabra = plantilla.postForObject(url, primerPalabra, String.class);
        return result;
    }
}
