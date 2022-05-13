package com.ceiba.recomendacion.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.recomendacion.comando.ComandoConsultarRecomendacion;
import com.ceiba.recomendacion.modelo.entidad.Recomendacion;
import com.ceiba.recomendacion.puerto.dao.DaoRecomendacion;
import com.ceiba.recomendacion.servicio.ServicioConsultarRecomendacion;
import com.ceiba.recomendacion.servicio.ServicioCrearRecomendacion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class ManejadorConsultarRecomendacion implements ManejadorComandoRespuesta<ComandoConsultarRecomendacion, ComandoRespuesta<RespApiBusqueda>> {

    private final DaoRecomendacion daoRecomendacion;
    private final ServicioCrearRecomendacion servicioCrearRecomendacion;
    private final ServicioConsultarRecomendacion consultarRecomendacion;
    private List<String> json;

    public ManejadorConsultarRecomendacion(DaoRecomendacion daoRecomendacion, ServicioCrearRecomendacion servicioCrearRecomendacion, ServicioConsultarRecomendacion consultarRecomendacion) {
        this.daoRecomendacion = daoRecomendacion;
        this.servicioCrearRecomendacion = servicioCrearRecomendacion;
        this.consultarRecomendacion = consultarRecomendacion;
    }

    public ComandoRespuesta<RespApiBusqueda> ejecutar(ComandoConsultarRecomendacion comandoConsultarRecomendacion){
        json = this.daoRecomendacion.consultar(comandoConsultarRecomendacion.getIdUsuario());
        String js = json.get(0);
        List<String> r = new ArrayList<String>(Arrays.asList(js.split(",")));
        Recomendacion recomendacion = new Recomendacion(recomendacionRuletaFC(r, comandoConsultarRecomendacion.getIdUsuario()));
        return new ComandoRespuesta<>(this.servicioCrearRecomendacion.ejecutar(recomendacion));
//        return new ComandoRespuesta<>(this.consultarRecomendacion.ejecutar(json));
    }

    private List<String> recomendacionRuletaFC (List<String> recomendaciones, Long id){
        Random claseRandom = new Random();
        String r1, r2;

        List<String> fC = this.daoRecomendacion.filtradoColaborativo(id);
        r1 = fC.get(claseRandom.nextInt(fC.size()));

        do {
            r2 = fC.get(claseRandom.nextInt(fC.size()));
        } while (r1.equals(r2));

        recomendaciones.set(1,r1);
        recomendaciones.set(2,r2);

        return recomendaciones;
    }
}
