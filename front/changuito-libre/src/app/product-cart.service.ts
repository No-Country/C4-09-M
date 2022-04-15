import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from './components/product-list/product';


@Injectable({
  providedIn: 'root'
})
export class ProductCartService {

  private _products : Product[] = [];
  private _productsSubjects : BehaviorSubject<Product[]> = new BehaviorSubject(this._products);
  public products : Observable<Product[]> = this._productsSubjects.asObservable();
  constructor() { }

  addToCart(product:Product){
    let index = this._products.findIndex(b => b.name === product.name);
    if(index === -1)
      this._products.push(product);
    else
      this._products[index].quantity = product.quantity;
    if(product.quantity == 0){
      this._products.splice(index,1);
    }
  }
}
