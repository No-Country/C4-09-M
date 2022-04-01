import { LoguinComponent } from './components/loguin/loguin.component';
import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProductsCarouselComponent } from './components/products-carousel/products-carousel.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
<<<<<<< HEAD
import { RegistrationUsersComponent } from './components/registration-users/registration-users.component';
=======
import { FooterComponent } from './components/footer/footer.component';
>>>>>>> 541796b269de583f491023209fec08b74b9e6022

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoguinComponent,
    ProductsCarouselComponent,
    AdminDashboardComponent,
<<<<<<< HEAD
    RegistrationUsersComponent
=======
    FooterComponent
>>>>>>> 541796b269de583f491023209fec08b74b9e6022
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
