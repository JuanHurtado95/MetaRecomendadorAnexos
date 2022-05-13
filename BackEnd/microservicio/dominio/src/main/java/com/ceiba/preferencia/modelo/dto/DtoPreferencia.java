package com.ceiba.preferencia.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPreferencia {

    private Long id;
    private Long idUsuario;
    private int menorPrecio;
    private int valoracionVendedor;
    private int envioGratis;
    private int productoNuevo;
    private int tiendaOficial;

}
