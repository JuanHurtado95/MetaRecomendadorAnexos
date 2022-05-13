package com.ceiba.feedback_implicito.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoFeedBack {
    private Long id;
    private Long id_usuario;
    private String id_producto;
    private String id_categoria;
    private LocalDate fecha;
    private String disponible;
}
