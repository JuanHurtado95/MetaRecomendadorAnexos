update preferencia
set id_usuario = :idUsuario,
    menor_precio = :menorPrecio,
    valoracion_vendedor = :valoracionVendedor,
    envio_gratis = :envioGratis,
    producto_nuevo = :productoNuevo,
    tienda_oficial = :tiendaOficial
where id = :id
