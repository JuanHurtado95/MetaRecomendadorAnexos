import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { Registro } from '../model/registro';
import { environment } from 'src/environments/environment';
import { Ingreso } from '../model/ingreso';
import { ResponseUsuario } from '../model/ResponseUsuario';
import { Subject } from 'rxjs';

@Injectable()
export class LoginService {

  label:boolean;

  labelMenu: Subject<boolean> = new Subject<boolean>();

  constructor(protected http:HttpService) { 
    this.labelMenu.subscribe((value) =>{
      this.label=value;
    });
  }
  
  updateMenu(){
    this.labelMenu.next(!this.label);
  }

  createIngreso(ingreso:Ingreso){
    return this.http.doPost<Ingreso, ResponseUsuario>(`${environment.endpoint}/usuarios/info`,ingreso);
  }

  createRegistro(registro:Registro){
    console.log(registro);
    return this.http.doPost<Registro, boolean>(`${environment.endpoint}/usuarios`,registro);
  }
}
