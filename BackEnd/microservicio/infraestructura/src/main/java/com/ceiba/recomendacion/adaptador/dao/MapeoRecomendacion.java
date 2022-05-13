package com.ceiba.recomendacion.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.recomendacion.comando.ComandoRecomendacion;
import com.zaxxer.hikari.pool.HikariProxyCallableStatement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoRecomendacion implements RowMapper<String>, MapperResult {


    @Override
    public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        String resultado = resultSet.getString("json");

        return resultado;
    }
}
