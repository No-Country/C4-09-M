import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration-users',
  templateUrl: './registration-users.component.html',
  styleUrls: ['./registration-users.component.css']
})
export class RegistrationUsersComponent implements OnInit {

  form: any = {};
  isSuccessful = false;
  isSignupFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(): void{
    this.authService.register(this.form).subscribe(
      data => {
        console.log(data);
        this.isSuccessful=true;
        this.isSignupFailed=false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignupFailed = true;
      }
    );
  }

}
