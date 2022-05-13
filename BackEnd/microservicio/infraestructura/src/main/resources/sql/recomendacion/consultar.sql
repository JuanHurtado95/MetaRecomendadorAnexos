select CONCAT (primera_recomendacion,',',seguda_recomendacion,',',tercera_recomendacion,',',cuarta_recomendacion) as json
from recomendadordb.dbo.recomendacion
where id_usuario = :idUsuario