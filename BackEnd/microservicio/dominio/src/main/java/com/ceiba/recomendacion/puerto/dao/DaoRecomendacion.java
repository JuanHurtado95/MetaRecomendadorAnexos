package com.ceiba.recomendacion.puerto.dao;

import java.util.List;

public interface DaoRecomendacion {

    List<String> consultar(Long id);

    List<String> filtradoColaborativo(Long id);
}
