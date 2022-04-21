import { TokenStorageService } from './../../services/token-storage.service';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loguin',
  templateUrl: './loguin.component.html',
  styleUrls: ['./loguin.component.css']
})
export class LoguinComponent implements OnInit {

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  showAdminBoard = false;
  showMerchBoard = false;
  showClient = false;

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    if(this.tokenStorage.getToken()){
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
      alert("¡Ya has iniciado sesión!");
      this.router.navigate([""]);
    }
  }

  onSubmit(): void {
    this.authService.login(this.form).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accesToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;

        this.navigate()
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  navigate():void {
    if(this.isLoggedIn){
      const user = this.tokenStorage.getUser();
      this.roles = this.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showClient = this.roles.includes('ROLE_CLIENT');
      this.showMerchBoard = this.roles.includes('ROLE_MERCHANDISER');


      if(this.showClient){
        this.router.navigate([""]);
      }else if(this.showMerchBoard){
        this.router.navigate(["merchandiser-dashboard"])
      }else if(this.showAdminBoard){
        this.router.navigate(["admin-dashboard"])
      }
    }
  }

}
