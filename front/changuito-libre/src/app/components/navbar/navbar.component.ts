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
  username = '';

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    const user = this.tokenStorageService.getUser();
    this.username = user.username;
  }

  logout():void{
    this.tokenStorageService.singOut();
    window.location.reload();
  }

}
