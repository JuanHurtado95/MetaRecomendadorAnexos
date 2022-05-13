package com.ceiba.preferencia.puerto.repositorio;

import com.ceiba.preferencia.modelo.entidad.Preferencia;

public interface RepositorioPreferencia {

    Long crear(Preferencia preferencia);

    void actualizar(Preferencia preferencia);

    Boolean existePreferenciaPorId(Long id);

    Boolean existeUsuarioPorId(Long idUsuario);
}
