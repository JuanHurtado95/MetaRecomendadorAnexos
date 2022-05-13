import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CrearLoginComponent } from './components/crear-login/crear-login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '@shared/shared.module';
import { LoginRoutingModule } from './login-routing.module';
import { LoginService } from './shared/service/login.service';
import { CrearRegistroComponent } from './components/crear-registro/crear-registro.component';



@NgModule({
  declarations: [
    CrearLoginComponent,
    CrearRegistroComponent
  ],
  imports: [
    CommonModule,
    LoginRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    SharedModule
  ],
  providers: [LoginService]
})
export class LoginModule { }
