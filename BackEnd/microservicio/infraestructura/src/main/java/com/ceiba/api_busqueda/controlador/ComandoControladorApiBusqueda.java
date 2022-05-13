package com.ceiba.api_busqueda.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.api_busqueda.comando.ComandoApiBusqueda;
import com.ceiba.api_busqueda.comando.manejador.ManejadorCrearApiBusqueda;
import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/apibusqueda")
@Api(tags = { "Controlador comando api busqueda"})
public class ComandoControladorApiBusqueda {

    private final ManejadorCrearApiBusqueda manejadorCrearApiBusqueda;

    public ComandoControladorApiBusqueda(ManejadorCrearApiBusqueda manejadorCrearApiBusqueda) {
        this.manejadorCrearApiBusqueda = manejadorCrearApiBusqueda;
    }

    @PostMapping
    @ApiOperation("Realizar busqueda")
    public ComandoRespuesta<RespApiBusqueda> buscar(@RequestBody ComandoApiBusqueda comandoApiBusqueda) throws IOException {
        return manejadorCrearApiBusqueda.ejecutar(comandoApiBusqueda); 
    }

}
