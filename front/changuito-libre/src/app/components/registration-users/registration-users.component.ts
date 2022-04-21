import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

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

  constructor(private authService: AuthService, private formBuilder: FormBuilder) { }

  registrerClientForm = this.formBuilder.group({
    firstname: [''],
    lastname: [''],
    username: [''],
    password: [''],
    email: [''],
    birthday: [''],
    dni: ['']

  });

  registrerMerchForm = this.formBuilder.group({
    name: [''],
    lastname: [''],
    username: [''],
    password: [''],
    email: [''],
    street: [''],
    dni: [''],
    cuit:['']

  });

  ngOnInit(): void {
  }

  onSubmitClient(): void{
    this.authService.registerClient(this.form).subscribe(
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

  onSubmitMerch(): void{
    this.authService.registerMerchandiser(this.form).subscribe(
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
