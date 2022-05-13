package com.ceiba.feedback_implicito.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class FeedBack {
    private Long id;
    private Long id_usuario;
    private String id_producto;
    private String id_categoria;
    private LocalDate fecha;
    private String disponible;

    public FeedBack(Long id, Long id_usuario, String id_producto, String id_categoria, LocalDate fecha, String disponible) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.fecha = fecha;
        this.disponible = disponible;
    }
}
