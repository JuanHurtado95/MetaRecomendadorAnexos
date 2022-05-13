package com.ceiba.busqueda.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoBusqueda {

    private Long id;
    private Long idUsuario;
    private String palabraBuscada;
    private String categoria;
}
