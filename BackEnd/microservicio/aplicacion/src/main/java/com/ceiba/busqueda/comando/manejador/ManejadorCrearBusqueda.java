package com.ceiba.busqueda.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.busqueda.comando.ComandoBusqueda;
import com.ceiba.busqueda.comando.fabrica.FabricaBusqueda;
import com.ceiba.busqueda.modelo.entidad.BusquedaAlmacenada;
import com.ceiba.busqueda.servicio.ServicioCrearBusqueda;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearBusqueda implements ManejadorComandoRespuesta<ComandoBusqueda, ComandoRespuesta<Long>> {

    private final FabricaBusqueda fabricaBusqueda;
    private final ServicioCrearBusqueda servicioCrearBusqueda;

    public ManejadorCrearBusqueda(FabricaBusqueda fabricaBusqueda, ServicioCrearBusqueda servicioCrearBusqueda) {
        this.fabricaBusqueda = fabricaBusqueda;
        this.servicioCrearBusqueda = servicioCrearBusqueda;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoBusqueda comandoBusqueda){
        BusquedaAlmacenada busquedaAlmacenada = this.fabricaBusqueda.crear(comandoBusqueda);
        return new ComandoRespuesta<>(this.servicioCrearBusqueda.ejecutar(busquedaAlmacenada));
    }

}
