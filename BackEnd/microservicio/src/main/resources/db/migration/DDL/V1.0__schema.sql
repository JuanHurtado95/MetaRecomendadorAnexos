create table usuario (
 id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 correo varchar(45) not null,
 genero varchar(45) not null,
 edad int not null,
 fecha_creacion date null
);

create table preferencia (
   id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
   id_usuario int not null,
   menor_precio int,
   valoracion_vendedor int,
   envio_gratis int,
   producto_nuevo int,
   tienda_oficial int
);

create table busqueda (
    id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    id_usuario int,
    palabra_buscada varchar(200) not null,
    categoria varchar(200)
);