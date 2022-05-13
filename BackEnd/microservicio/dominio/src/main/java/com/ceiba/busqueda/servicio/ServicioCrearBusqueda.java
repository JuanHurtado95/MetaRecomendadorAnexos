package com.ceiba.busqueda.servicio;

import com.ceiba.busqueda.modelo.entidad.BusquedaAlmacenada;
import com.ceiba.busqueda.puerto.repositorio.RepositorioBusqueda;

public class ServicioCrearBusqueda {

    private final RepositorioBusqueda repositorioBusqueda;

    public ServicioCrearBusqueda(RepositorioBusqueda repositorioBusqueda) {
        this.repositorioBusqueda = repositorioBusqueda;
    }

    public Long ejecutar(BusquedaAlmacenada busquedaAlmacenada){
        return this.repositorioBusqueda.crear(busquedaAlmacenada);
    }
}
