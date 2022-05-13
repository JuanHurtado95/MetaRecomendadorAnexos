package com.ceiba.api_busqueda.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespApiBusqueda {

    private String site_id;
    private String query;
    private List<ResultMCO> results;
}
