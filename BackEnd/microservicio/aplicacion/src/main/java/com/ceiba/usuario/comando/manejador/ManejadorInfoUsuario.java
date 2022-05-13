package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoInfoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.servicio.ServicioInfoUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorInfoUsuario implements ManejadorComandoRespuesta<ComandoInfoUsuario, DtoUsuario> {

    private ServicioInfoUsuario servicioInfoUsuario;

    public ManejadorInfoUsuario(ServicioInfoUsuario servicioInfoUsuario) {
        this.servicioInfoUsuario = servicioInfoUsuario;
    }

    @Override
    public DtoUsuario ejecutar(ComandoInfoUsuario comando) {
        return this.servicioInfoUsuario.ejecutar(comando.getClave(), comando.getCorreo());
    }
}
