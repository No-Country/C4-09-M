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

const routes: Routes = [
  { path: '', component: LandingPageComponent},
  { path: 'login', component: LoguinComponent},
  { path: 'admin', component: AdminDashboardComponent},
  { path: 'merchandiser-dashboard', component: MerchandiserDashboardComponent },
  { path: 'registrarse', component: RegistrationUsersComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

