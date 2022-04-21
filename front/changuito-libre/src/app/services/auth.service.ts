import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client';
import { Merch } from '../model/merch';

const AUTH_API= 'https://changuito-libre.herokuapp.com/';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) {


   }
   login(credentials: { username: any; password: any; }): Observable<any> {
     return this.httpClient.post(AUTH_API+'signin',{
       username: credentials.username,
       password: credentials.password
     }, httpOptions);
  }

  registerClient(client: Client): Observable<any> {
    return this.httpClient.post(AUTH_API+'clients/signup',{
      username: client.user.username,
      password: client.user.password,
      firstname: client.firstname,
      lastname: client.lastname,
      email: client.email,
      birthday: client.birthday,
      dni: client.dni
    }, httpOptions);
 }

 registerMerchandiser(merch: Merch): Observable<any> {
  return this.httpClient.post(AUTH_API+'merchandisers/signup',{
    username: merch.user.username,
    password: merch.user.password,
    name: merch.name,
    description: merch.description,
    street: merch.street,
    streetNumber: merch.streetNumber,
    email: merch.email,
    cuit: merch.cuit
  }, httpOptions);
}


}
