package com.ceiba.busqueda.comando.fabrica;

import com.ceiba.busqueda.comando.ComandoBusqueda;
import com.ceiba.busqueda.modelo.entidad.BusquedaAlmacenada;
import org.springframework.stereotype.Component;

@Component
public class FabricaBusqueda {

    public BusquedaAlmacenada crear(ComandoBusqueda comandoBusqueda){
        return new BusquedaAlmacenada(
                comandoBusqueda.getId(),
                comandoBusqueda.getIdUsuario(),
                comandoBusqueda.getPalabraBuscada(),
                comandoBusqueda.getCategoria()
        );
    }
}
