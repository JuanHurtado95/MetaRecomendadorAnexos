SELECT palabra_buscada as json
FROM recomendadordb.dbo.busqueda as b
where b.id_usuario in (select DISTINCT id_usuario
						from recomendadordb.dbo.busqueda as b
						where palabra_buscada = (select primera_recomendacion
													from recomendadordb.dbo.recomendacion r
													where r.id_usuario = :idUsuario))
AND palabra_buscada <> (select primera_recomendacion
						from recomendadordb.dbo.recomendacion r
						where r.id_usuario = :idUsuario)