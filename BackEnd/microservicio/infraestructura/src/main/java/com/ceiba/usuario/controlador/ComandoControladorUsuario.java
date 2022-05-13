package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoInfoUsuario;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorInfoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Controlador comando usuario"})
public class  ComandoControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;
	private final ManejadorEliminarUsuario manejadorEliminarUsuario;
	private final ManejadorActualizarUsuario manejadorActualizarUsuario;
	private final ManejadorInfoUsuario manejadorInfoUsuario;

    @Autowired
    public ComandoControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario,
									 ManejadorEliminarUsuario manejadorEliminarUsuario,
									 ManejadorActualizarUsuario manejadorActualizarUsuario, ManejadorInfoUsuario manejadorInfoUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
		this.manejadorEliminarUsuario = manejadorEliminarUsuario;
		this.manejadorActualizarUsuario = manejadorActualizarUsuario;
		this.manejadorInfoUsuario = manejadorInfoUsuario;
	}

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoUsuario comandoUsuario) {
        return manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

	@PostMapping(value="/info")
	@ApiOperation("info Usuario")
	public DtoUsuario consultarInfoUsuario(@RequestBody ComandoInfoUsuario comandoInfoUsuario) {
		return manejadorInfoUsuario.ejecutar(comandoInfoUsuario);
	}

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Usuario")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarUsuario.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Usuario")
	public void actualizar(@RequestBody ComandoUsuario comandoUsuario,@PathVariable Long id) {
		comandoUsuario.setId(id);
		manejadorActualizarUsuario.ejecutar(comandoUsuario);
	}
}
