import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const API_URL = 'https://changuito-libre.herokuapp.com/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any>{
    return this.http.get(API_URL + 'all', { responseType: 'text'});
  }

  getClients(): Observable<any>{
    return this.http.get(API_URL + 'clients', { responseType: 'text'});
  }

  getMerchBoard(): Observable<any>{
    return this.http.get(API_URL + 'merchandisers', { responseType: 'text'});
  }

  getAdminBoard(): Observable<any>{
    return this.http.get(API_URL + '', { responseType: 'text'});
  }
}
