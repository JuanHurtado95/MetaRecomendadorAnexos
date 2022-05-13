package com.ceiba.feedback_implicito.modelo;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoFeedBack {
    private Long id;
    private Long id_usuario;
    private String id_producto;
    private String id_categoria;
    private LocalDate fecha;
    private String disponible;
}
