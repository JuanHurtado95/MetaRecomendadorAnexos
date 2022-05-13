import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecurityGuard } from '@core/guard/security.guard';
import { HomeComponent } from '@home/home.component';




const routes: Routes = [
  { path: '', redirectTo: '/buscador', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, canActivate: [SecurityGuard]  },
  { path: 'producto', loadChildren: () => import('@producto/producto.module').then(mod => mod.ProductoModule) },
  { path: 'buscador', loadChildren: () => import('@buscador/buscador.module').then(mod => mod.BuscadorModule) },
  { path: 'recomendador', loadChildren: () => import('@recomendador/recomendador.module').then(mod => mod.RecomendadorModule) },
  { path: 'login', loadChildren: () => import('@login/login.module').then(mod => mod.LoginModule) }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
