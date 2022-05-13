package com.ceiba.preferencia.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.preferencia.modelo.dto.DtoPreferencia;
import com.ceiba.preferencia.puerto.dao.DaoPreferencia;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPreferenciaMysql implements DaoPreferencia {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="preferencia", value="listar")
    private static String sqlListar;

    public DaoPreferenciaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPreferencia> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPreferencia());
    }
}
