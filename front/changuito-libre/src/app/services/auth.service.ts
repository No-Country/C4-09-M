import { User } from './../model/user';
import { UserDto } from './../Dtos/userDto';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

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

  register(user: User): Observable<any> {
    return this.httpClient.post(AUTH_API+'signup',{
      username: user.username,
      password: user.password
    }, httpOptions);
 }


}
