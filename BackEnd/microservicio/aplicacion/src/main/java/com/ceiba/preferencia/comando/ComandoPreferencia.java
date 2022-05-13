package com.ceiba.preferencia.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPreferencia {

    private Long id;
    private Long idUsuario;
    private int menorPrecio;
    private int valoracionVendedor;
    private int envioGratis;
    private int productoNuevo;
    private int tiendaOficial;
}
