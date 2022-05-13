import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SwalService } from '@core/services/swal.service';
import { Registro } from '@login/shared/model/registro';
import { LoginService } from '@login/shared/service/login.service';


@Component({
  selector: 'app-crear-registro',
  templateUrl: './crear-registro.component.html',
  styleUrls: ['./crear-registro.component.css']
})
export class CrearRegistroComponent implements OnInit {
  registro:Registro = new Registro();
  confirmarClave:String;
  constructor(
    private router: Router,
    private service: LoginService,
    protected swalService: SwalService
    ) { }

  ngOnInit(): void {
  }

   login(){
    this.router.navigate(["login/"]);
  }

  registrar(){
    
    if(this.registro.clave == this.confirmarClave){
      this.service.createRegistro(this.registro).subscribe(
        () => {
          this.swalService.succes("Registro creado correctamente");
          this.router.navigate(["login/"]);
          console.log(this.registro)
        },
        (error) => {
          this.swalService.danger(error.error.mensaje);
        }
      );
    }else{
      this.swalService.danger("Las contraseñas deben de coincidir");
    }
  }
}
