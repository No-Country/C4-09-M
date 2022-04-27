import { ProductDataService } from 'src/app/product-data.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from '../model/product';
import { environment } from 'src/environments/environment';

const URL = environment.baseUrl + 'product/';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private products: Product[] = [];
  private _productsSubjects: BehaviorSubject<Product[]> = new BehaviorSubject(this.products);
  public _products: Observable<Product[]> = this._productsSubjects.asObservable();

  constructor(private http: HttpClient, private productDataService: ProductDataService) {
    this.http.get<Product[]>(URL).subscribe(data => {
      this.products.push(...data);
    });
  }

  setProduct(products: Product[]) {
    this.products = products;
  }

  getProducts() {
    return this.productDataService.getProducts()
  }

  addProduct(product: Product){
    return this.productDataService.saveProduct(product).subscribe(
      (product: any)=>{
        this.products.push(Object.assign({}, product));
      }
     );
  }

  updateProduct(id:number, product: Product){
    const productMod = this.products.find(product => product.id == id)!;
    productMod.id = product.id;
    productMod.brand = product.brand;
    productMod.description = product.description;
    productMod.categoryDto = product.categoryDto;
    productMod.idImage = product.idImage;
    productMod.wholesaler_price = product.wholesaler_price;
    productMod.name = product.name;
  //  productMod.cart = product.cart;
    productMod.retail_price = product.retail_price;
    productMod.status = product.status;
    productMod.stock = product.stock;
    //productMod.content = product.content;

    return this.productDataService.updateProduct(id,product);

  }

  deleteProduct(id:number, product: Product){
    const index = this.products.findIndex(product => product.id == id);
    this.products.splice(index,1);
    this.productDataService.deleteProdutc(id)
  }
}
