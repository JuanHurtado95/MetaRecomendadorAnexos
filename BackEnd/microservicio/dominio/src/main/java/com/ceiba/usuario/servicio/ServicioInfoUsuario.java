package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import java.util.List;

public class ServicioInfoUsuario {

    private RepositorioUsuario repositorioUsuario;

    List<DtoUsuario> lista;

    public ServicioInfoUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public DtoUsuario ejecutar(String clave, String correo){
        lista = this.repositorioUsuario.infoUsuario(clave, correo);
        DtoUsuario resp = lista.get(0);
        return resp;
    }
}
