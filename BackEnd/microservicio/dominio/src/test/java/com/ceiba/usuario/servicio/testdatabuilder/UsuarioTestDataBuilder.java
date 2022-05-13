package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private String correo;
    private String genero;
    private int edad;
    private LocalDate fechaCreacion;

    public UsuarioTestDataBuilder() {
        nombre = "1234";
        clave = "1234";
        fechaCreacion = LocalDate.now();
    }

    public UsuarioTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombreUsuario) {
        this.nombre = nombreUsuario;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombre, clave, correo, genero, edad, fechaCreacion);
    }
}
