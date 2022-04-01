import { NavbarComponent } from './components/navbar/navbar.component';
import { MerchandiserDashboardComponent } from './components/merchandiser-dashboard/merchandiser-dashboard.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { LoguinComponent } from './components/loguin/loguin.component';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: NavbarComponent},
  { path: 'login', component: LoguinComponent},
  { path: 'admin', component: AdminDashboardComponent},
  { path: 'merchandiser-dashboard', component: MerchandiserDashboardComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
