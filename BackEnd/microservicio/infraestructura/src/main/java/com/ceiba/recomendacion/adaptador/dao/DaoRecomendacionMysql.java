package com.ceiba.recomendacion.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.recomendacion.puerto.dao.DaoRecomendacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoRecomendacionMysql implements DaoRecomendacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="recomendacion", value="consultar")
    private static String sqlConsultar;

    @SqlStatement(namespace="recomendacion", value="filtradoColaborativo")
    private static String sqlFC;

    public DaoRecomendacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<String> consultar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlConsultar, paramSource, new MapeoRecomendacion());
    }

    @Override
    public List<String> filtradoColaborativo(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlFC, paramSource, new MapeoRecomendacion());
    }
}
