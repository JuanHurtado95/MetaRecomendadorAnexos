package com.ceiba.busqueda.controlador;


import com.ceiba.busqueda.consulta.ManejadorListarBusquedas;
import com.ceiba.busqueda.modelo.dto.DtoBusqueda;
import com.ceiba.preferencia.modelo.dto.DtoPreferencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/busquedas")
@Api(tags={"Controlador consulta busqueda"})
public class ConsultaControladorBusqueda {

    private final ManejadorListarBusquedas manejadorListarBusquedas;


    public ConsultaControladorBusqueda(ManejadorListarBusquedas manejadorListarBusquedas) {
        this.manejadorListarBusquedas = manejadorListarBusquedas;
    }

    @GetMapping
    @ApiOperation("Listar Busquedas")
    public List<DtoBusqueda> listar() {
        return this.manejadorListarBusquedas.ejecutar();
    }
}
