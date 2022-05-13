package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private Long id;
    private String nombre;
    private String clave;
    private String correo;
    private String genero;
    private int edad;
    private LocalDate fechaCreacion;

}
