import { ReportsFormsViewComponent } from './components/reports-forms-view/reports-forms-view.component';
import { EditarPerfilComponent } from './components/admin-dashboard/editar-perfil/editar-perfil.component';
import { AdminUsuarioModificarComponent } from './components/admin-dashboard/admin-usuario-modificar/admin-usuario-modificar.component';
import { AdminUsuarioComponent } from './components/admin-dashboard/admin-usuario/admin-usuario.component';
import { AdminPaymentsComponent } from './components/admin-dashboard/admin-payments/admin-payments.component';
import { PerfilUsuarioComponent } from './components/perfil-usuario/perfil-usuario.component';
import { AboutUsViewComponent } from './components/about-us-view/about-us-view.component';
import { ProductosViewComponent } from './components/productos-view/productos-view.component';
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
import { AdminNavComponent } from './components/admin-dashboard/admin-nav/admin-nav.component';
import { AdminMerchComponent } from './components/admin-dashboard/admin-merch/admin-merch.component';
import { AdminPerfilComponent } from './components/admin-dashboard/admin-perfil/admin-perfil.component';
import { AdminReportesComponent } from './components/admin-dashboard/admin-reportes/admin-reportes.component';
import { AdminSideBarComponent } from './components/admin-dashboard/admin-side-bar/admin-side-bar.component';
import { ProductsDetailsViewComponent } from './components/productos-view/products-details-view/products-details-view.component';
import { PaymentComponent } from './components/payment/payment.component';
import { OrderComponent } from './components/order/order.component';
import { CartComponent } from './components/cart/cart.component';
import { ProductDashboardComponent } from './components/product-dashboard/product-dashboard.component';

const routes: Routes = [
  { path: '', component: LandingPageComponent},
  { path: 'login', component: LoguinComponent},
  { path: 'admin', component: AdminDashboardComponent},
  { path: 'admin-payments', component: AdminPaymentsComponent},
  { path: 'admin-usuarios', component: AdminUsuarioComponent},
  { path: 'admin-usuarios-modificar', component: AdminUsuarioModificarComponent},
  { path: 'admin-perfil', component: AdminPerfilComponent},
  { path: 'admin-perfil-editar', component: EditarPerfilComponent},
  { path: 'admin-merch-agregar', component: AdminMerchComponent},
  { path: 'admin-reportes', component: AdminReportesComponent},
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
  { path: 'productos', component: ProductosViewComponent},
  { path: 'products-view-detail', component: ProductsDetailsViewComponent},
  { path: 'us', component: AboutUsViewComponent },
  { path: 'mi-perfil', component: PerfilUsuarioComponent },
  { path: 'report-us', component: ReportsFormsViewComponent },
  { path: 'pagar', component: PaymentComponent},
  { path: 'ticket', component: OrderComponent},
  { path: 'changuito', component: ProductDashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

