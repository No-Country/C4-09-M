import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

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
    firstname: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    lastname: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    username: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    password: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    email: ['', [Validators.required, Validators.email]],
    birthday: ['', [Validators.required]],
    dni: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]]
  });

  registrerMerchForm = this.formBuilder.group({
    name: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    lastname: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    username: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    password: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    email: ['', [Validators.required, Validators.email]],
    street: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    dni: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    cuit:['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]]

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
