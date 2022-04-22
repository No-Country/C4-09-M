import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const API_URL = 'https://changuito-libre.herokuapp.com/';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  getClients(): Observable<any> {
    return this.http.get(API_URL + 'clients');
  }

  getMerchandisers(): Observable<any> {
    return this.http.get(API_URL + 'merchandisers');
  }

  getProducts(): Observable<any> {
    return this.http.get(API_URL + 'products/all');
  }

}
