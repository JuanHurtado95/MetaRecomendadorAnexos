package com.ceiba.feedback_implicito.comando.fabrica;

import com.ceiba.feedback_implicito.comando.ComandoFeedBack;
import com.ceiba.feedback_implicito.modelo.FeedBack;
import org.springframework.stereotype.Component;

@Component
public class FabricaFeedBack {

    public FeedBack crear(ComandoFeedBack comandoFeedBack){
        return new FeedBack(
                comandoFeedBack.getId(),
                comandoFeedBack.getId_usuario(),
                comandoFeedBack.getId_producto(),
                comandoFeedBack.getId_categoria(),
                comandoFeedBack.getFecha(),
                comandoFeedBack.getDisponible()
        );
    }
}
