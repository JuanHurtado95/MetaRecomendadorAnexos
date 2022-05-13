package com.ceiba.usuario.comando;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario{

    private Long id;
    private String nombre;
    private String clave;
    private String correo;
    private String genero;
    private int edad;
    private LocalDate fecha;
}
