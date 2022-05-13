package com.ceiba.api_busqueda.comando.fabrica;

import com.ceiba.api_busqueda.comando.ComandoApiBusqueda;
import com.ceiba.api_busqueda.modelo.entidad.Busqueda;
import org.springframework.stereotype.Component;

@Component
public class FabricaApiBusqueda {

    public Busqueda crear(ComandoApiBusqueda comandoApiBusqueda){
        return new Busqueda(
                comandoApiBusqueda.getIdUsuario(),
                comandoApiBusqueda.getPalabra()
        );
    }

}
