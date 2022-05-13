import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearLoginComponent } from './components/crear-login/crear-login.component';
import { CrearRegistroComponent } from './components/crear-registro/crear-registro.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: '',
        component: CrearLoginComponent
      },
      {
        path: 'registro',
        component: CrearRegistroComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
