import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from './model/product';
import { environment } from 'src/environments/environment';


const URL = environment.baseUrl + 'product/';
@Injectable({
  providedIn: 'root'
})
export class ProductDataService {

    private products : Product[] = [];
    private _productsSubjects : BehaviorSubject<Product[]> = new BehaviorSubject(this.products);
    public _products : Observable<Product[]> = this._productsSubjects.asObservable();
  

  constructor(private http: HttpClient) {

  //  this.http.get<Product[]>(URL).subscribe(data => {
  //    this._products.push(...data);
   // });

  }

  urlBase = 'https://changuito-libre.herokuapp.com/product/';

  getProducts(){
    return this.http.get(this.urlBase+'all');
  }


  getAllPage(){
    return this.http.get(this.urlBase+'paged');
  }



  saveProduct(product: Product){
    return this.http.post(this.urlBase+'save', product);
  }

  updateProduct(idProd:number ,product: Product){
    return this.http.put(this.urlBase+idProd,product).subscribe(
      (response) => {
        console.log('resultado modificar producto: ' + response);
      },
      (error) => console.log('Error en modificar producto:' + error)
    );
  }

  deleteProdutc(idProd:number ){
    return this.http.delete(this.urlBase+idProd).subscribe(
      (response) => {
        console.log('resultado eliminar producto: ' + response);
      },
      (error) => console.log('Error en eliminar producto:' + error)
    );
  }

  getOneById(idProd: number){
    return this.http.get(this.urlBase+idProd);
  }

}
