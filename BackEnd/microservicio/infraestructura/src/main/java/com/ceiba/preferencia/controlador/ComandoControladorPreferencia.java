package com.ceiba.preferencia.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.preferencia.comando.ComandoPreferencia;
import com.ceiba.preferencia.comando.manejador.ManejadorActualizarPreferencia;
import com.ceiba.preferencia.comando.manejador.ManejadorCrearPreferencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/preferencias")
@Api(tags = { "Controlador comando preferencia"})
public class ComandoControladorPreferencia {

    private final ManejadorCrearPreferencia manejadorCrearPreferencia;
    private final ManejadorActualizarPreferencia manejadorActualizarPreferencia;

    @Autowired
    public ComandoControladorPreferencia(ManejadorCrearPreferencia manejadorCrearPreferencia, ManejadorActualizarPreferencia manejadorActualizarPreferencia) {
        this.manejadorCrearPreferencia = manejadorCrearPreferencia;
        this.manejadorActualizarPreferencia = manejadorActualizarPreferencia;
    }

    @PostMapping
    @ApiOperation("Crear Preferencia")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPreferencia comandoPreferencia){
        return manejadorCrearPreferencia.ejecutar(comandoPreferencia);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Preferencia")
    public void actualizar(@RequestBody ComandoPreferencia comandoPreferencia, @PathVariable Long id) {
        comandoPreferencia.setId(id);
        manejadorActualizarPreferencia.ejecutar(comandoPreferencia);
    }
}
