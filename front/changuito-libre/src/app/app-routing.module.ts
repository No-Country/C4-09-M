import { MerchPerfilModificarComponent } from './components/merchandiser-dashboard/merch-perfil-modificar/merch-perfil-modificar.component';
import { MerchMetodosPagoCrearComponent } from './components/merchandiser-dashboard/merch-metodos-pago-crear/merch-metodos-pago-crear.component';
import { MerchProductoModificarComponent } from './components/merchandiser-dashboard/merch-producto-modificar/merch-producto-modificar.component';
import { MerchProductoCrearComponent } from './components/merchandiser-dashboard/merch-producto-crear/merch-producto-crear.component';
import { MerchPerfilComponent } from './components/merchandiser-dashboard/merch-perfil/merch-perfil.component';
import { MerchMetodosPagoComponent } from './components/merchandiser-dashboard/merch-metodos-pago/merch-metodos-pago.component';
import { MerchReportesComponent } from './components/merchandiser-dashboard/merch-reportes/merch-reportes.component';
import { MerchProductsComponent } from './components/merchandiser-dashboard/merch-products/merch-products.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { FooterComponent } from './components/footer/footer.component';
import { RegistrationUsersComponent } from './components/registration-users/registration-users.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MerchandiserDashboardComponent } from './components/merchandiser-dashboard/merchandiser-dashboard.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { LoguinComponent } from './components/loguin/loguin.component';
import { AppComponent } from './app.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MerchVentasComponent } from './components/merchandiser-dashboard/merch-ventas/merch-ventas.component';

const routes: Routes = [
  { path: '', component: LandingPageComponent},
  { path: 'login', component: LoguinComponent},
  { path: 'admin', component: AdminDashboardComponent},
  { path: 'merchandiser-dashboard', component: MerchandiserDashboardComponent },
  { path: 'merch-productos', component: MerchProductsComponent },
  { path: 'merch-ventas', component: MerchVentasComponent },
  { path: 'merch-reportes', component: MerchReportesComponent },
  { path: 'merch-metodos-pago', component: MerchMetodosPagoComponent},
  { path: 'merch-metodos-pago-crear', component: MerchMetodosPagoCrearComponent},
  { path: 'merch-producto-crear', component: MerchProductoCrearComponent},
  { path: 'merch-producto-modificar', component: MerchProductoModificarComponent},
  { path: 'merch-perfil', component: MerchPerfilComponent},
  { path: 'merch-perfil-modificar', component: MerchPerfilModificarComponent},
  { path: 'registrarse', component: RegistrationUsersComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

