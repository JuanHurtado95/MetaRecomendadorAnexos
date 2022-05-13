package com.ceiba.preferencia.controlador;

import com.ceiba.preferencia.consulta.ManejadorListarPreferencias;
import com.ceiba.preferencia.modelo.dto.DtoPreferencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/preferencias")
@Api(tags={"Controlador consulta preferencia"})
public class ConsultaControladorPreferencia {

    private final ManejadorListarPreferencias manejadorListarPreferencias;

    public ConsultaControladorPreferencia(ManejadorListarPreferencias manejadorListarPreferencias) {
        this.manejadorListarPreferencias = manejadorListarPreferencias;
    }

    @GetMapping
    @ApiOperation("Listar Preferencias")
    public List<DtoPreferencia> listar() {
        return this.manejadorListarPreferencias.ejecutar();
    }
}
