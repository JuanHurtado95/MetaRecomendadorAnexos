package com.ceiba.preferencia.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Preferencia {

    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO = "Se debe ingresar el id del usuario";
    private static final String EL_ID_DEL_USUARIO_DEBE_SER_POSITIVO = "El id del usuario debe ser positivo";
    private static final String SE_DEBE_INGRESAR_EL_MENOR_PRECIO = "Se debe ingresar el menor precio";
    private static final String SE_DEBE_INGRESAR_LA_VALORACION_VENDEDOR = "Se debe ingresar la valoracion del vendedor";
    private static final String SE_DEBE_INGRESAR_EL_ENVIO_GRATIS = "Se debe ingresar el envio gratis";
    private static final String SE_DEBE_INGRESAR_EL_PRODUCTO_NUEVO = "Se debe ingresar el producto nuevo";
    private static final String SE_DEBE_INGRESAR_LA_TIENDA_OFICIAL = "Se debe ingresar la tienda oficial";

    private Long id;
    private Long idUsuario;
    private int menorPrecio;
    private int valoracionVendedor;
    private int envioGratis;
    private int productoNuevo;
    private int tiendaOficial;

    public Preferencia(Long id, Long idUsuario, int menorPrecio, int valoracionVendedor, int envioGratis,
                       int productoNuevo, int tiendaOficial){

        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO);
        validarPositivo((double) idUsuario, EL_ID_DEL_USUARIO_DEBE_SER_POSITIVO);
        validarObligatorio(menorPrecio, SE_DEBE_INGRESAR_EL_MENOR_PRECIO);
        validarObligatorio(valoracionVendedor, SE_DEBE_INGRESAR_LA_VALORACION_VENDEDOR);
        validarObligatorio(envioGratis, SE_DEBE_INGRESAR_EL_ENVIO_GRATIS);
        validarObligatorio(productoNuevo, SE_DEBE_INGRESAR_EL_PRODUCTO_NUEVO);
        validarObligatorio(tiendaOficial, SE_DEBE_INGRESAR_LA_TIENDA_OFICIAL);


        this.id = id;
        this.idUsuario = idUsuario;
        this.menorPrecio = menorPrecio;
        this.valoracionVendedor = valoracionVendedor;
        this.envioGratis = envioGratis;
        this.productoNuevo = productoNuevo;
        this.tiendaOficial = tiendaOficial;
    }

}
