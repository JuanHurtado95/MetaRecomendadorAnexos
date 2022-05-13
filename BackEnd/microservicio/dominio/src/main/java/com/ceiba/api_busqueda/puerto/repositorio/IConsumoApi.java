package com.ceiba.api_busqueda.puerto.repositorio;

import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.busqueda.modelo.entidad.BusquedaAlmacenada;

public interface IConsumoApi {

    RespApiBusqueda crearBusquedaMCO(String palabra, int limite);

    RespApiBusqueda crearBusquedaMEC(String palabra, int limite);

    String almacenarBusqueda(BusquedaAlmacenada busquedaAlmacenada);

}
