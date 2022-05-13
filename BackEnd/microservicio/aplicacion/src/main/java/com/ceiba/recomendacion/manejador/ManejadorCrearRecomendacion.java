package com.ceiba.recomendacion.manejador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.recomendacion.comando.ComandoRecomendacion;
import com.ceiba.recomendacion.fabrica.FabricaRecomendacion;
import com.ceiba.recomendacion.modelo.entidad.Recomendacion;
import com.ceiba.recomendacion.servicio.ServicioCrearRecomendacion;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearRecomendacion implements ManejadorComandoRespuesta<ComandoRecomendacion, ComandoRespuesta<RespApiBusqueda>> {

    private final FabricaRecomendacion fabricaRecomendacion;
    private final ServicioCrearRecomendacion servicioCrearRecomendacion;

    public ManejadorCrearRecomendacion(FabricaRecomendacion fabricaRecomendacion, ServicioCrearRecomendacion servicioCrearRecomendacion) {
        this.fabricaRecomendacion = fabricaRecomendacion;
        this.servicioCrearRecomendacion = servicioCrearRecomendacion;
    }

    @Override
    public ComandoRespuesta<RespApiBusqueda> ejecutar(ComandoRecomendacion palabras) {
        Recomendacion recomendacion = this.fabricaRecomendacion.crear(palabras);
        return new ComandoRespuesta<>(this.servicioCrearRecomendacion.ejecutar(recomendacion));
    }
}
