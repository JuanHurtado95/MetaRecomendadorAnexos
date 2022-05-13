package com.ceiba.api_busqueda.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.api_busqueda.comando.ComandoApiBusqueda;
import com.ceiba.api_busqueda.comando.fabrica.FabricaApiBusqueda;
import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.api_busqueda.modelo.entidad.Busqueda;
import com.ceiba.api_busqueda.servicio.ServicioCrearApiBusqueda;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearApiBusqueda implements ManejadorComandoRespuesta<ComandoApiBusqueda, ComandoRespuesta<RespApiBusqueda>> {

    private final FabricaApiBusqueda fabricaApiBusqueda;
    private final ServicioCrearApiBusqueda servicioCrearApiBusqueda;

    public ManejadorCrearApiBusqueda(FabricaApiBusqueda fabricaApiBusqueda, ServicioCrearApiBusqueda servicioCrearApiBusqueda) {
        this.fabricaApiBusqueda = fabricaApiBusqueda;
        this.servicioCrearApiBusqueda = servicioCrearApiBusqueda;
    }

    @Override
    public ComandoRespuesta<RespApiBusqueda> ejecutar(ComandoApiBusqueda comandoApiBusqueda) {
        Busqueda busqueda = this.fabricaApiBusqueda.crear(comandoApiBusqueda);
        return new ComandoRespuesta<>(this.servicioCrearApiBusqueda.ejecutar(busqueda));
    }
}