package com.ceiba.preferencia.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.preferencia.comando.ComandoPreferencia;
import com.ceiba.preferencia.comando.fabrica.FabricaPreferencia;
import com.ceiba.preferencia.modelo.entidad.Preferencia;
import com.ceiba.preferencia.servicio.ServicioActualizarPreferencia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPreferencia implements ManejadorComando<ComandoPreferencia> {

    private final FabricaPreferencia fabricaPreferencia;
    private final ServicioActualizarPreferencia servicioActualizarPreferencia;

    public ManejadorActualizarPreferencia(FabricaPreferencia fabricaPreferencia, ServicioActualizarPreferencia servicioActualizarPreferencia) {
        this.fabricaPreferencia = fabricaPreferencia;
        this.servicioActualizarPreferencia = servicioActualizarPreferencia;
    }

    public void ejecutar(ComandoPreferencia comandoPreferencia) {
        Preferencia preferencia = this.fabricaPreferencia.crear(comandoPreferencia);
        this.servicioActualizarPreferencia.ejecutar(preferencia);
    }
}
