import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CrearRecomendacionComponent } from './components/crear-recomendacion/crear-recomendacion.component';
import { RecomendadorService } from './shared/service/recomendador.service';
import { RecomendadorRoutingModule } from './recomendador-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '@shared/shared.module';



@NgModule({
  declarations: [
    CrearRecomendacionComponent
  ],
  imports: [
    CommonModule,
    RecomendadorRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    SharedModule
  ],
  providers: [RecomendadorService]
})
export class RecomendadorModule { }
