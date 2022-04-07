import { HeroComponent } from './components/hero/hero.component';
import { CartComponent } from './components/cart/cart.component';
import { AdminMerchComponent } from './components/admin-dashboard/admin-merch/admin-merch.component';
import { ProductsComponent } from './components/products/products.component';
import { AdminUsuariosRegistradosComponent } from './components/admin-dashboard/admin-usuarios-registrados/admin-usuarios-registrados.component';
import { AdminPaymentsComponent } from './components/admin-dashboard/admin-payments/admin-payments.component';
import { IvyCarouselModule } from 'angular-responsive-carousel';
import { ProductosViewComponent } from './components/productos-view/productos-view.component';
import { ProductsComponent } from './components/products/products.component';

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
    ProductsComponent,
    ProductosViewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    IvyCarouselModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }