package com.ceiba.api_busqueda.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Busqueda {

    private static final String SE_DEBE_INGRESAR_LA_PALABRA_BUSCADA = "Se debe ingresar la palabra buscada";

    private Long idUsuario;
    private String palabraBuscada;

    public Busqueda(Long idUsuario, String palabraBuscada) {

        validarObligatorio(palabraBuscada, SE_DEBE_INGRESAR_LA_PALABRA_BUSCADA);

        this.idUsuario = idUsuario;
        this.palabraBuscada = palabraBuscada;
    }

}
