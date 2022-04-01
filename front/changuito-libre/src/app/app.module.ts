import { LoguinComponent } from './components/loguin/loguin.component';
import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProductsCarouselComponent } from './components/products-carousel/products-carousel.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoguinComponent,
    ProductsCarouselComponent,
    AdminDashboardComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
