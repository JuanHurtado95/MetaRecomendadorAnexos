select id,nombre,clave,correo,genero,edad,fecha_creacion
from usuario
where correo = :correo and clave = :clave;