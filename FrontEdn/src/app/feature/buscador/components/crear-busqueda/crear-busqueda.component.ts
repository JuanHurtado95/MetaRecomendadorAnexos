import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Api } from '@buscador/shared/model/api';
//import { SwalService } from "@core/services/swal.service";
import { Buscador } from '@buscador/shared/model/buscador';
import { BuscadorService } from '@buscador/shared/service/buscador.service';
import { Producto } from '@buscador/shared/model/producto';

@Component({
  selector: "app-crear-busqueda",
  templateUrl: "./crear-busqueda.component.html",
  styleUrls: ["./crear-busqueda.component.css"],
})
export class CrearBusquedaComponent implements OnInit {
  productos:Producto[];
  buscador: Buscador = new Buscador();
  api: Api = new Api();
  constructor(
    private router: Router,
    private service: BuscadorService,
    //protected swalService: SwalService
    ) { }

  ngOnInit() {
    this.buscador.idUsuario = JSON.parse( localStorage.getItem('id'));
    console.log(this.buscador);
    
  }

  Buscar() {
    this.service.createBusqueda(this.buscador).subscribe( result => {
        //console.log(result);
        Object.assign(this.api, result);
        this.productos = this.api.valor.results;
        console.log(this.productos);
        this.router.navigate(["buscador"]);
       
      },
    );
  }

}
