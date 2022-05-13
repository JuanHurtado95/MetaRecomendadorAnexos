package com.ceiba.preferencia.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.preferencia.comando.ComandoPreferencia;
import com.ceiba.preferencia.comando.fabrica.FabricaPreferencia;
import com.ceiba.preferencia.modelo.entidad.Preferencia;
import com.ceiba.preferencia.servicio.ServicioCrearPreferencia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPreferencia implements ManejadorComandoRespuesta<ComandoPreferencia, ComandoRespuesta<Long>> {

    private final FabricaPreferencia fabricaPreferencia;
    private final ServicioCrearPreferencia servicioCrearPreferencia;


    public ManejadorCrearPreferencia(FabricaPreferencia fabricaPreferencia, ServicioCrearPreferencia servicioCrearPreferencia) {
        this.fabricaPreferencia = fabricaPreferencia;
        this.servicioCrearPreferencia = servicioCrearPreferencia;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPreferencia comandoPreferencia){
        Preferencia preferencia = this.fabricaPreferencia.crear(comandoPreferencia);
        return new ComandoRespuesta<>(this.servicioCrearPreferencia.ejecutar(preferencia));
    }
}
