package com.ceiba.busqueda.controlador;
import com.ceiba.ComandoRespuesta;
import com.ceiba.busqueda.comando.ComandoBusqueda;
import com.ceiba.busqueda.comando.manejador.ManejadorCrearBusqueda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/busquedas")
@Api(tags = { "Controlador comando busqueda"})
public class ComandoControladorBusqueda {

    private ManejadorCrearBusqueda manejadorCrearBusqueda;

    public ComandoControladorBusqueda(ManejadorCrearBusqueda manejadorCrearBusqueda) {
        this.manejadorCrearBusqueda = manejadorCrearBusqueda;
    }

    @PostMapping
    @ApiOperation("Crear Preferencia")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoBusqueda comandoBusqueda){
        return manejadorCrearBusqueda.ejecutar(comandoBusqueda);
    }
}
