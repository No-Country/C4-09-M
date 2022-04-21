import { TokenStorageService } from './services/token-storage.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  private roles!: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showMerchBoard = false;
  showClient = false;
  username!: string;

  constructor(private tokenStorageService: TokenStorageService){}

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if(this.isLoggedIn){
      const user = this.tokenStorageService.getUser();
      this.roles = this.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showClient = this.roles.includes('ROLE_CLIENT');
      this.showMerchBoard = this.roles.includes('ROLE_MERCHANDISER');

      this.username = user.username;
    }
  }

  logout():void{
    this.tokenStorageService.singOut();
    window.location.reload();
  }

  title = 'changuito-libre';
}
