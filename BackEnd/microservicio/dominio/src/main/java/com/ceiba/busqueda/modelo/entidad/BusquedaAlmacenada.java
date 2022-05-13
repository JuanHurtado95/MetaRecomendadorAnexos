package com.ceiba.busqueda.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Setter
@Getter
public class BusquedaAlmacenada {

    private static final String SE_DEBE_INGRESAR_LA_PALABRA_BUSCADA = "Se debe ingresar la palabra buscada";
    private static final String EL_ID_DE_LA_BUSQUEDA_DEBE_SER_POSITIVA = "El id de la busqueda debe ser positiva";

    private Long id;
    private Long idUsuario;
    private String palabraBuscada;
    private String categoria;

    public BusquedaAlmacenada(Long id, Long idUsuario, String palabraBuscada, String categoria) {

        validarObligatorio(palabraBuscada, SE_DEBE_INGRESAR_LA_PALABRA_BUSCADA);

        this.id = id;
        this.idUsuario = idUsuario;
        this.palabraBuscada = palabraBuscada;
        this.categoria = categoria;
    }
}
