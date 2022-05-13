update usuario
set nombre = :nombre,
	clave = :clave,
	correo = :correo,
	genero = :genero,
	edad = :edad,
	fecha_creacion = :fechaCreacion
where id = :id