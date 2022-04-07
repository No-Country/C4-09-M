import { HeroComponent } from './components/hero/hero.component';
import { CartComponent } from './components/cart/cart.component';
import { AdminMerchComponent } from './components/admin-dashboard/admin-merch/admin-merch.component';

import { AdminPaymentsComponent } from './components/admin-dashboard/admin-payments/admin-payments.component';
import { IvyCarouselModule } from 'angular-responsive-carousel';
import { ProductosViewComponent } from './components/productos-view/productos-view.component';
import { ProductsComponent } from './components/products/products.component';
import { AdminNavComponent } from './components/admin-dashboard/admin-nav/admin-nav.component';
import { AdminPerfilComponent } from './components/admin-dashboard/admin-perfil/admin-perfil.component';
import { AdminSideBarComponent } from './components/admin-dashboard/admin-side-bar/admin-side-bar.component';
import { AdminReportesComponent } from './components/admin-dashboard/admin-reportes/admin-reportes.component';
import { NgModule } from '@angular/core';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AppComponent } from './app.component';
import { ProductsCarouselComponent } from './components/products-carousel/products-carousel.component';
import { LoguinComponent } from './components/loguin/loguin.component';
import { MerchandiserDashboardComponent } from './components/merchandiser-dashboard/merchandiser-dashboard.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { FooterComponent } from './components/footer/footer.component';
import { RegistrationUsersComponent } from './components/registration-users/registration-users.component';
import { MerchNavComponent } from './components/merchandiser-dashboard/merch-nav/merch-nav.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
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
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AdminUsuarioComponent } from './components/admin-dashboard/admin-usuario/admin-usuario.component';
import { AdminUsuarioModificarComponent } from './components/admin-dashboard/admin-usuario-modificar/admin-usuario-modificar.component';
import { PerfilUsuarioComponent } from './components/perfil-usuario/perfil-usuario.component';
import { AboutUsViewComponent } from './components/about-us-view/about-us-view.component';
import { HeroPresentationComponent } from './components/hero-presentation/hero-presentation.component';

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
    CartComponent,
    AdminMerchComponent,
    AdminNavComponent,
    AdminPerfilComponent,
    AdminSideBarComponent,
    AdminReportesComponent,
    AdminPaymentsComponent,
    AdminUsuarioComponent,
    AdminUsuarioModificarComponent,
    ProductsComponent,
    ProductosViewComponent,
    AboutUsViewComponent,
    PerfilUsuarioComponent,
    HeroPresentationComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    IvyCarouselModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
