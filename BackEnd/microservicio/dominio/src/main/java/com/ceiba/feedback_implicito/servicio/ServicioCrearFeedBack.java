package com.ceiba.feedback_implicito.servicio;

import com.ceiba.feedback_implicito.modelo.FeedBack;
import com.ceiba.feedback_implicito.puerto.RepositorioFeedBack;

public class ServicioCrearFeedBack {

    private final RepositorioFeedBack repositorioFeedBack;


    public ServicioCrearFeedBack(RepositorioFeedBack repositorioFeedBack) {
        this.repositorioFeedBack = repositorioFeedBack;
    }

    public Long ejecutar(FeedBack feedBack){
        return this.repositorioFeedBack.crear(feedBack);
    }
}
