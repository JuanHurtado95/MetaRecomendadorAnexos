import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BuscadorRoutingModule } from './buscador-routing.module';
import { CrearBusquedaComponent } from './components/crear-busqueda/crear-busqueda.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BuscadorService } from './shared/service/buscador.service';
import { SharedModule } from '@shared/shared.module';



@NgModule({
  declarations: [
    CrearBusquedaComponent
  ],
  imports: [
    CommonModule,
    BuscadorRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    SharedModule
  ],
  exports:[
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  providers: [BuscadorService]
})
export class BuscadorModule { }
