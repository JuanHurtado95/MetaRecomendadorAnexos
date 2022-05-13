package com.ceiba.busqueda.consulta;

import com.ceiba.busqueda.modelo.dto.DtoBusqueda;
import com.ceiba.busqueda.puerto.dao.DaoBusqueda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarBusquedas {

    private final DaoBusqueda daoBusqueda;

    public ManejadorListarBusquedas(DaoBusqueda daoBusqueda) {
        this.daoBusqueda = daoBusqueda;
    }

    public List<DtoBusqueda> ejecutar(){ return this.daoBusqueda.listar(); }
}
