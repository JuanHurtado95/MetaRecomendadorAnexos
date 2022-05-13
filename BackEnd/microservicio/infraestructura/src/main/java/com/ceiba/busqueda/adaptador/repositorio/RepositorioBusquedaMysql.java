package com.ceiba.busqueda.adaptador.repositorio;

import com.ceiba.busqueda.modelo.entidad.BusquedaAlmacenada;
import com.ceiba.busqueda.puerto.repositorio.RepositorioBusqueda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioBusquedaMysql implements RepositorioBusqueda {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="busqueda", value="crear")
    private static String sqlCrear;


    public RepositorioBusquedaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(BusquedaAlmacenada busquedaAlmacenada) {
        return this.customNamedParameterJdbcTemplate.crear(busquedaAlmacenada, sqlCrear);
    }
}
