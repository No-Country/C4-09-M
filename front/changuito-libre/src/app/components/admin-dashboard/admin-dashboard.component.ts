import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { User } from './../../model/user';
import { Merch } from './../../model/merch';
import { UserService } from './../../services/user.service';
import { MerchService } from './../../services/merch.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  roles!: string[];
  isLoggedIn = false;
  isAdmin = false;
  username!: string;

  constructor(private merchSerice: MerchService, private userService: UserService,
    private token: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    this.isLoggedIn = !this.token.getToken();
    const user = this.token.getUser();
    if(this.roles.includes('ROLE_ADMIN')){
      this.isAdmin = true;
    }

    this.username = user.username;


  }

  showAlert(){
    alert('Contenido no disponible');
    this.router.navigate(['login'])
  }
}
