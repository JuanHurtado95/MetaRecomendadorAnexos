package com.ceiba.recomendacion;

import com.ceiba.ComandoRespuesta;
import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.recomendacion.comando.ComandoConsultarRecomendacion;
import com.ceiba.recomendacion.manejador.ManejadorConsultarRecomendacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/ConsultaRecomendacion")
@Api(tags = { "Controlador consulta recomendacion"})
public class ConsultaControladorRecomendacion {

    private final ManejadorConsultarRecomendacion manejadorConsultarRecomendacion;

    public ConsultaControladorRecomendacion(ManejadorConsultarRecomendacion manejadorConsultarRecomendacion) {
        this.manejadorConsultarRecomendacion = manejadorConsultarRecomendacion;
    }

    @PostMapping
    @ApiOperation("Consultar recomendaciones")
    public ComandoRespuesta<RespApiBusqueda> consultarRecomendacion(@RequestBody ComandoConsultarRecomendacion comandoConsultarRecomendacion) throws IOException {
        return manejadorConsultarRecomendacion.ejecutar(comandoConsultarRecomendacion);
    }
}
