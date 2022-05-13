package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_CORREO_DE_USUARIO = "Se debe ingresar el correo de usuario";
    private static final String SE_DEBE_UN_CORREO_DE_USUARIO_VALIDO = "Se debe ingresar un correo de usuario valido";
    private static final String SE_DEBE_INGRESAR_EL_GENERO_DE_USUARIO = "Se debe ingresar el genero de usuario";
    private static final String SE_DEBE_INGRESAR_LA_EDAD_DEL_USUARIO = "Se debe ingresar la edad del usuario";
    private static final String LA_EDAD_DEL_USUARIO_DEBE_SER_POSITIVA = "La edad del usuario debe ser positiva";


    private static final int LONGITUD_MINIMA_CLAVE = 4;
    private static final String REGEX_CORREO = "([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+";

    private Long id;
    private String nombre;
    private String clave;
    private String correo;
    private String genero;
    private int edad;
    private LocalDate fechaCreacion;

    public Usuario(Long id,String nombre, String clave, String correo, String genero, int edad, LocalDate fechaCreacion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(clave, SE_DEBE_INGRESAR_LA_CLAVE);
        validarLongitud(clave, LONGITUD_MINIMA_CLAVE, String.format(LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A,LONGITUD_MINIMA_CLAVE));
        validarObligatorio(correo, SE_DEBE_INGRESAR_EL_CORREO_DE_USUARIO);
        validarObligatorio(genero, SE_DEBE_INGRESAR_EL_GENERO_DE_USUARIO);
        validarRegex(correo, REGEX_CORREO, SE_DEBE_UN_CORREO_DE_USUARIO_VALIDO);
        validarObligatorio(edad, SE_DEBE_INGRESAR_LA_EDAD_DEL_USUARIO);
        validarPositivo((double) edad, LA_EDAD_DEL_USUARIO_DEBE_SER_POSITIVA);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
        this.genero = genero;
        this.edad = edad;
        this.fechaCreacion = fechaCreacion;
    }

}
