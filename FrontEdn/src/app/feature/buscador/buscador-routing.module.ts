import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearBusquedaComponent } from './components/crear-busqueda/crear-busqueda.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: '',
        component: CrearBusquedaComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BuscadorRoutingModule { }
