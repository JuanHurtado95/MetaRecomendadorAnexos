import { Injectable } from '@angular/core';
import { Api } from '@buscador/shared/model/api';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core/services/http.service';

@Injectable()
export class RecomendadorService {

  constructor(protected http:HttpService) { }
  createRecomendacion(id:number){
    console.log(id);
    return this.http.doPost<number , Api>(`${environment.endpoint}/ConsultaRecomendacion`, id);
  }
}
