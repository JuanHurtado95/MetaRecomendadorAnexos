package com.ceiba.preferencia.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.preferencia.modelo.entidad.Preferencia;
import com.ceiba.preferencia.puerto.repositorio.RepositorioPreferencia;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPreferenciaMysql implements RepositorioPreferencia {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="preferencia", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="preferencia", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="preferencia", value="existePreferenciaPorId")
    private static String sqlExistePreferencia;

    @SqlStatement(namespace="preferencia", value="existeUsuarioPorId")
    private static String sqlExisteUsuario;

    public RepositorioPreferenciaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Preferencia preferencia) {
        return this.customNamedParameterJdbcTemplate.crear(preferencia, sqlCrear);
    }

    @Override
    public void actualizar(Preferencia preferencia) {
        this.customNamedParameterJdbcTemplate.actualizar(preferencia, sqlActualizar);
    }

    @Override
    public Boolean existePreferenciaPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePreferencia,paramSource, Boolean.class);
    }

    @Override
    public Boolean existeUsuarioPorId(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", idUsuario);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteUsuario,paramSource, Boolean.class);
    }
}
