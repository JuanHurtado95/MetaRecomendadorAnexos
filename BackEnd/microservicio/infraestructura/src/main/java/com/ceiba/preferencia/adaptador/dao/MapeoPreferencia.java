package com.ceiba.preferencia.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.preferencia.modelo.dto.DtoPreferencia;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPreferencia implements RowMapper<DtoPreferencia>, MapperResult {

    @Override
    public DtoPreferencia mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idUsuario = resultSet.getLong("id_usuario");
        int menorPrecio = resultSet.getInt("menor_precio");
        int valoracionVendedor = resultSet.getInt("valoracion_vendedor");
        int envioGratis = resultSet.getInt("envio_gratis");
        int productoNuevo = resultSet.getInt("producto_nuevo");
        int tiendaOficial = resultSet.getInt("tienda_oficial");

        return new DtoPreferencia(id, idUsuario, menorPrecio, valoracionVendedor, envioGratis, productoNuevo, tiendaOficial);
    }
}
