export interface User{
    correo:String;
    clave:String;
}

export interface UserResponse{
    id: number;
    nombre: String;
    clave: String;
    correo: String;
    genero: String;
    edad: number;
    fechaCreacion: Date;
}