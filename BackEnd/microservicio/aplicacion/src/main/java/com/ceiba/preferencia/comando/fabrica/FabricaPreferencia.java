package com.ceiba.preferencia.comando.fabrica;

import com.ceiba.preferencia.comando.ComandoPreferencia;
import com.ceiba.preferencia.modelo.entidad.Preferencia;
import org.springframework.stereotype.Component;

@Component
public class FabricaPreferencia {

    public Preferencia crear(ComandoPreferencia comandoPreferencia){
        return new Preferencia(
                comandoPreferencia.getId(),
                comandoPreferencia.getIdUsuario(),
                comandoPreferencia.getMenorPrecio(),
                comandoPreferencia.getValoracionVendedor(),
                comandoPreferencia.getEnvioGratis(),
                comandoPreferencia.getProductoNuevo(),
                comandoPreferencia.getTiendaOficial()

        );
    }
}
