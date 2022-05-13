package com.ceiba.busqueda.adaptador.dao;

import com.ceiba.busqueda.modelo.dto.DtoBusqueda;
import com.ceiba.busqueda.puerto.dao.DaoBusqueda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoBusquedaMysql implements DaoBusqueda {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="busqueda", value="listar")
    private static String sqlListar;

    public DaoBusquedaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoBusqueda> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoBusqueda());
    }
}
