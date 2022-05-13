import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { Api } from '../model/api';
import { Buscador } from '../model/buscador';

@Injectable()
export class BuscadorService {

  buscador:Buscador

  constructor(protected http:HttpService) { }

  createBusqueda(buscador:Buscador){
    console.log(buscador);
    return this.http.doPost< Buscador, Api>(`${environment.endpoint}/apibusqueda`, buscador);
  }
}
