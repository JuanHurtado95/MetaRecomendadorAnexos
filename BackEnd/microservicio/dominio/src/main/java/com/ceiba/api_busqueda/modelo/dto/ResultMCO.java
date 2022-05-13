package com.ceiba.api_busqueda.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultMCO {

    private String id;
    private String title;
    private VendedorMCO seller;
    private float price;
    private String currency_id;
    private int sold_quantity;
    private String condition;
    private String permalink;
    private String thumbnail;
    private Envio shipping;
    private String category_id;


}
