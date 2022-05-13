package com.ceiba.recomendacion.fabrica;

import com.ceiba.recomendacion.comando.ComandoRecomendacion;
import com.ceiba.recomendacion.modelo.entidad.Recomendacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaRecomendacion {

    public Recomendacion crear(ComandoRecomendacion comandoRecomendacion){
        return new Recomendacion(
                comandoRecomendacion.getPalabra()
        );
    }
}
