import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { CrearRecomendacionComponent } from "./components/crear-recomendacion/crear-recomendacion.component";

const routes: Routes = [
    {
      path: '',
      children: [
        {
          path: '',
          component: CrearRecomendacionComponent
        }
      ]
    }
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class RecomendadorRoutingModule { }