import { LoguinComponent } from './components/loguin/loguin.component';
import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProductsCarouselComponent } from './components/products-carousel/products-carousel.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { MerchandiserDashboardComponent } from './components/merchandiser-dashboard/merchandiser-dashboard.component';
import { RegistrationUsersComponent } from './components/registration-users/registration-users.component';
import { FooterComponent } from './components/footer/footer.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { MerchNavComponent } from './components/merchandiser-dashboard/merch-nav/merch-nav.component';
import { MerchSideBarComponent } from './components/merchandiser-dashboard/merch-side-bar/merch-side-bar.component';
import { MerchProductsComponent } from './components/merchandiser-dashboard/merch-products/merch-products.component';
import { MerchVentasComponent } from './components/merchandiser-dashboard/merch-ventas/merch-ventas.component';
import { MerchReportesComponent } from './components/merchandiser-dashboard/merch-reportes/merch-reportes.component';
import { MerchMetodosPagoComponent } from './components/merchandiser-dashboard/merch-metodos-pago/merch-metodos-pago.component';
import { MerchPerfilComponent } from './components/merchandiser-dashboard/merch-perfil/merch-perfil.component';
import { MerchProductoCrearComponent } from './components/merchandiser-dashboard/merch-producto-crear/merch-producto-crear.component';
import { MerchProductoModificarComponent } from './components/merchandiser-dashboard/merch-producto-modificar/merch-producto-modificar.component';
import { MerchMetodosPagoCrearComponent } from './components/merchandiser-dashboard/merch-metodos-pago-crear/merch-metodos-pago-crear.component';
import { MerchPerfilModificarComponent } from './components/merchandiser-dashboard/merch-perfil-modificar/merch-perfil-modificar.component';
import { TeamComponent } from './components/team/team.component';
import { HeroComponent } from './components/hero/hero.component';
<<<<<<< HEAD
import { AdminNavComponent } from './admin-dashboard/admin-nav/admin-nav.component';
import { AdminVentasComponent } from './components/admin-dashboard/admin-ventas/admin-ventas.component';
import { NavComponent } from './components/admin-dashboard/nav/nav.component';
import { AdminPerfilComponent } from './components/admin-dashboard/admin-perfil/admin-perfil.component';
import { AdminMerchComponent } from './components/admin-dashboard/admin-merch/admin-merch.component';
import { AdminSideBarComponent } from './components/admin-dashboard/admin-side-bar/admin-side-bar.component';
import { EditarPerfilComponent } from './components/admin-dashboard/editar-perfil/editar-perfil.component';
import { AdminReportesComponent } from './components/admin-dashboard/admin-reportes/admin-reportes.component';
=======
import { CartComponent } from './components/cart/cart.component';
>>>>>>> c047dc962084fe7ff5f54899d6f529bf391ff2c9

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoguinComponent,
    ProductsCarouselComponent,
    AdminDashboardComponent,
    MerchandiserDashboardComponent,
    RegistrationUsersComponent,
    FooterComponent,
    LandingPageComponent,
    MerchNavComponent,
    MerchSideBarComponent,
    MerchProductsComponent,
    MerchVentasComponent,
    MerchReportesComponent,
    MerchMetodosPagoComponent,
    MerchPerfilComponent,
    MerchProductoCrearComponent,
    MerchProductoModificarComponent,
    MerchMetodosPagoCrearComponent,
    MerchPerfilModificarComponent,
    TeamComponent,
    HeroComponent,
<<<<<<< HEAD
    AdminNavComponent,
    AdminVentasComponent,
    NavComponent,
    AdminPerfilComponent,
    AdminMerchComponent,
    AdminSideBarComponent,
    EditarPerfilComponent,
    AdminReportesComponent
=======
    CartComponent
>>>>>>> c047dc962084fe7ff5f54899d6f529bf391ff2c9
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [], 
  bootstrap: [AppComponent]
})
export class AppModule { }
