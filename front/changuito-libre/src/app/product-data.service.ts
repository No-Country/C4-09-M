import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from './components/product-list/product';


const URL = 'http://localhost:8080/product/all';
@Injectable({
  providedIn: 'root'
})
export class ProductDataService {

  private _products : Product[] = [];
  private _productsSubjects : BehaviorSubject<Product[]> = new BehaviorSubject(this._products);
  public products : Observable<Product[]> = this._productsSubjects.asObservable();

  constructor(private http: HttpClient) {
    this.http.get<Product[]>(URL).subscribe(data => {
      this._products.push(...data);
    });
  }


}
