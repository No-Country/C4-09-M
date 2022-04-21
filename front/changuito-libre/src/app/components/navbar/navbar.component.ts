import { User } from './../../model/user';

import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn = false;
  isMerch = false;
  isClient = false;
  isAdmin = false;
  username = '';
  private roles!: string[];

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = this.roles;
      this.username = user.username;
      this.isMerch = this.roles.includes('ROLE_MERCHANDISER');
      this.isAdmin = this.roles.includes('ROLE_ADMIN');
      this.isClient = this.roles.includes('ROLE_CLIENT');
    }

  }

  logout(): void {
    this.tokenStorageService.singOut();
    window.location.reload();
  }

}
