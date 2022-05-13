package com.ceiba.api_busqueda.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoApiBusqueda {

    private long idUsuario;
    private String palabra;
}
