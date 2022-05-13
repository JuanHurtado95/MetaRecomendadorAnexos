import { Component, OnInit, Input } from '@angular/core';
import { MenuItem } from '@core/modelo/menu-item';
import { ResponseUsuario } from '@login/shared/model/ResponseUsuario';

@Component({
  selector: 'app-navbar',
  templateUrl: 'navbar.component.html',
  styles: [`:host {
    border: 0 solid #e1e1e1;
    border-bottom-width: 1px;
    display: block;
    height: 48px;
    padding: 0 16px;
  }

  nav a {
    color: #8f8f8f;
    font-size: 14px;
    font-weight: 500;
    line-height: 48px;
    margin-right: 20px;
    text-decoration: none;
    vertical-align: middle;
    cursor: pointer;
  }

  nav a.router-link-active {
    color: #106cc8;
  }`],
})
export class NavbarComponent implements OnInit {

  @Input()
  items: MenuItem[];
  persona: ResponseUsuario;

  constructor() {
    this.persona = JSON.parse(localStorage.getItem('user'));

    if(this.persona==null){
      this.persona = new ResponseUsuario;
      this.persona.nombre = "- Ingresa para tener una recomendacion";
    }
   }

  ngOnInit() {
  }

}
