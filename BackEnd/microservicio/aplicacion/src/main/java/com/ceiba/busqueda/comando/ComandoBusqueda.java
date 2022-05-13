package com.ceiba.busqueda.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoBusqueda {

    private Long id;
    private Long idUsuario;
    private String palabraBuscada;
    private String categoria;

}
