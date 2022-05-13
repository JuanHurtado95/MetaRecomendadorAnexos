package com.ceiba.preferencia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.preferencia.modelo.entidad.Preferencia;
import com.ceiba.preferencia.puerto.repositorio.RepositorioPreferencia;

public class ServicioCrearPreferencia {

    private static final String lA_PREFERENCIA_YA_EXISTE = "La preferencia ya existe en el sistema";
    private static final String El_USUARIO_NO_ESTA_EN_EL_SISTEMA = "El usuario no se encuentra registrado en el sistema";

    private final RepositorioPreferencia repositorioPreferencia;

    public ServicioCrearPreferencia(RepositorioPreferencia repositorioPreferencia){
        this.repositorioPreferencia = repositorioPreferencia;
    }

    public Long ejecutar(Preferencia preferencia){
        validarExistenciaPreferencia(preferencia);
        validarExistenciaUsuario(preferencia);
        return this.repositorioPreferencia.crear(preferencia);
    }

    public void validarExistenciaPreferencia(Preferencia preferencia){
        boolean existe = this.repositorioPreferencia.existePreferenciaPorId(preferencia.getId());
        if(existe){
            throw new ExcepcionValorInvalido(lA_PREFERENCIA_YA_EXISTE);
        }
    }

    public void validarExistenciaUsuario(Preferencia preferencia){
        boolean existe = this.repositorioPreferencia.existeUsuarioPorId(preferencia.getIdUsuario());
        if(!existe){
            throw new ExcepcionValorInvalido(El_USUARIO_NO_ESTA_EN_EL_SISTEMA);
        }
    }
}
