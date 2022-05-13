import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SwalService } from '@core/services/swal.service';
import { Ingreso } from '@login/shared/model/ingreso';
import { ResponseUsuario } from '@login/shared/model/ResponseUsuario';
import { LoginService } from '@login/shared/service/login.service';

@Component({
  selector: 'app-crear-login',
  templateUrl: './crear-login.component.html',
  styleUrls: ['./crear-login.component.css']
})
export class CrearLoginComponent implements OnInit {
  ingreso:Ingreso = new Ingreso();
  resp:ResponseUsuario = new ResponseUsuario();
  label:string;
  constructor(
    private router: Router,
    private service: LoginService,
    protected swalService: SwalService
    ) { }

  ngOnInit(): void {
    
    if(localStorage.getItem('id') != '0' && localStorage.getItem('id') != null){
      localStorage.clear();
      this.router.navigate(["/login"]).then(() =>{
        window.location.reload();
      });
    }
  }

  registro(){
    this.router.navigate(["login/registro"]);
  }

  ingresar(){
    this.service.createIngreso(this.ingreso).subscribe(
      resp => {
        console.log(resp);
        localStorage.setItem("id", JSON.stringify(resp.id));
        localStorage.setItem("user", JSON.stringify(resp));
        this.service.updateMenu();
        console.log('Label ' + this.service.label);
        this.router.navigate(["/buscador"]).then(() =>{
          window.location.reload();
        });
        
      },
      (error) => {
        this.swalService.danger(error.error.mensaje);
      }
    )
  }

}
