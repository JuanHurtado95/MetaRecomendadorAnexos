package com.ceiba.recomendacion;

import com.ceiba.ComandoRespuesta;
import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.recomendacion.comando.ComandoRecomendacion;
import com.ceiba.recomendacion.manejador.ManejadorCrearRecomendacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/recomendacion")
@Api(tags = { "Controlador comando recomendacion"})
public class ComandoControladorRecomendacion {
/*
    private final ManejadorCrearRecomendacion manejadorCrearRecomendacion;

    public ComandoControladorRecomendacion(ManejadorCrearRecomendacion manejadorCrearRecomendacion) {
        this.manejadorCrearRecomendacion = manejadorCrearRecomendacion;
    }

    @PostMapping
    @ApiOperation("Realizar recomendacion")
    public ComandoRespuesta<RespApiBusqueda> recomendar(@RequestBody ComandoRecomendacion comandoRecomendacion) throws IOException {
        return manejadorCrearRecomendacion.ejecutar(comandoRecomendacion);
    }*/

}
