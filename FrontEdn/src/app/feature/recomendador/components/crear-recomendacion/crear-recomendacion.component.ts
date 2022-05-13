import { Component, OnInit } from '@angular/core';
import { Api } from '@buscador/shared/model/api';
import { Router } from '@angular/router';
import { SwalService } from '@core/services/swal.service';
import { RecomendadorService } from '@recomendador/shared/service/recomendador.service';
import { Producto } from '@buscador/shared/model/producto';


@Component({
  selector: "app-crear-recomendacion",
  templateUrl: "./crear-recomendacion.component.html",
  styleUrls: ["./crear-recomendacion.component.css"]
})
export class CrearRecomendacionComponent implements OnInit {

  api:Api = new Api();
  productos:Producto[];
  wait:Boolean = true;
  user:boolean= false;
  
  constructor(
    private service: RecomendadorService, 
    private router: Router, 
    protected swalService: SwalService) 
    { }

  ngOnInit(): void {
    let id = JSON.parse( localStorage.getItem('id'));
    console.log(id);
    if(id!=null){
      this.user = true;
      this.service.createRecomendacion(id).subscribe( result => {
        Object.assign(this.api, result);
        this.wait = false;
        this.productos = this.api.valor.results;
      })
    }
  }

  login(){
    this.router.navigate(["login/"]);
  }

}
