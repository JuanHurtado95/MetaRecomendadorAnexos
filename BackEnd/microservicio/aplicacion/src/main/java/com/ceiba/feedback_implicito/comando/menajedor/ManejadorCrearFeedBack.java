package com.ceiba.feedback_implicito.comando.menajedor;

import com.ceiba.ComandoRespuesta;
import com.ceiba.feedback_implicito.comando.ComandoFeedBack;
import com.ceiba.feedback_implicito.comando.fabrica.FabricaFeedBack;
import com.ceiba.feedback_implicito.modelo.FeedBack;
import com.ceiba.feedback_implicito.servicio.ServicioCrearFeedBack;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFeedBack implements ManejadorComandoRespuesta<ComandoFeedBack, ComandoRespuesta<Long>> {

    private final FabricaFeedBack fabricaFeedBack;
    private final ServicioCrearFeedBack servicioCrearFeedBack;

    public ManejadorCrearFeedBack(FabricaFeedBack fabricaFeedBack, ServicioCrearFeedBack servicioCrearFeedBack) {
        this.fabricaFeedBack = fabricaFeedBack;
        this.servicioCrearFeedBack = servicioCrearFeedBack;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoFeedBack comandoFeedBack) {
        FeedBack feedBack = this.fabricaFeedBack.crear(comandoFeedBack);
        return new ComandoRespuesta<>(this.servicioCrearFeedBack.ejecutar(feedBack));
    }
}
