package com.ceiba.recomendacion.servicio;

import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.api_busqueda.puerto.repositorio.IConsultaApi;
import com.ceiba.recomendacion.modelo.entidad.Recomendacion;

import java.util.List;

public class ServicioConsultarRecomendacion {

    private final IConsultaApi iConsultaApi;
    private String json;

    public ServicioConsultarRecomendacion(IConsultaApi iConsultaApi) {
        this.iConsultaApi = iConsultaApi;
    }

    public RespApiBusqueda ejecutar(List<String> recomendacion){
        json = recomendacion.get(0);
        return this.iConsultaApi.consultaProducto(json);
    }
}
