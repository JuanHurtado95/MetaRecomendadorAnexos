import { formatDate } from "@angular/common";

export class Registro{
    nombre:String;
    clave:String;
    correo:String;
    edad:number;
    genero:String;
    fecha:String = formatDate(Date(), 'yyyy-MM-dd', 'en-US');
}