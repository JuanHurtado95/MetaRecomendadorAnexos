import { Component } from '@angular/core';
import { MenuItem } from '@core/modelo/menu-item';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app-base';
  public companies: MenuItem[] = [
    { url: '/buscador', nombre: 'MetaBuscador' },
    { url: '/recomendador', nombre: 'MetaRecomendador' },
    { url: '/login', nombre: localStorage.getItem('id') === null ? 'Ingresar':'Salir'} 
    
  ];
  
  constructor( ){ }
}
