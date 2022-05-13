package com.ceiba.feedback_implicito.adaptador.repositorio;

import com.ceiba.feedback_implicito.modelo.FeedBack;
import com.ceiba.feedback_implicito.puerto.RepositorioFeedBack;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFeedBackMysql implements RepositorioFeedBack{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="feedback", value="crear")
    private static String sqlCrear;


    public RepositorioFeedBackMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(FeedBack feedBack) {
        return this.customNamedParameterJdbcTemplate.crear(feedBack, sqlCrear);
    }
}
