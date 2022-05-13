package com.ceiba.busqueda.adaptador.dao;

import com.ceiba.busqueda.modelo.dto.DtoBusqueda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.preferencia.modelo.dto.DtoPreferencia;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoBusqueda implements RowMapper<DtoBusqueda>, MapperResult {

    @Override
    public DtoBusqueda mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idUsuario = resultSet.getLong("id_usuario");
        String palabraBuscada = resultSet.getString("palabra_buscada");
        String categoria = resultSet.getString("categoria");

        return new DtoBusqueda(id, idUsuario, palabraBuscada, categoria);
    }

}
