package com.ceiba.preferencia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.preferencia.modelo.entidad.Preferencia;
import com.ceiba.preferencia.puerto.repositorio.RepositorioPreferencia;

public class ServicioActualizarPreferencia {

    private static final String LA_PREFERENCIA_NO_EXISTE_EN_EL_SISTEMA = "La preferencia no existe en el sistema";

    private final RepositorioPreferencia repositorioPreferencia;

    public ServicioActualizarPreferencia(RepositorioPreferencia repositorioPreferencia) {
        this.repositorioPreferencia = repositorioPreferencia;
    }

    public void ejecutar(Preferencia preferencia){
        validarExistenciaPreferencia(preferencia);
        this.repositorioPreferencia.actualizar(preferencia);
    }

    public void validarExistenciaPreferencia(Preferencia preferencia){
        boolean existe = repositorioPreferencia.existePreferenciaPorId(preferencia.getId());
        if(!existe){
            throw new ExcepcionValorInvalido(LA_PREFERENCIA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
