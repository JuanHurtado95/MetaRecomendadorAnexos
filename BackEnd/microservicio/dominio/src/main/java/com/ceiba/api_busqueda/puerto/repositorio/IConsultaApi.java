package com.ceiba.api_busqueda.puerto.repositorio;

import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;

public interface IConsultaApi {

    RespApiBusqueda consultaProducto(String palabra);
}
