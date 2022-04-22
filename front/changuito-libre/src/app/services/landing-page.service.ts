import { Product } from './../model/product';
import { ProductService } from './product.service';
import { ProductCarouselService } from './product-carousel.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LandingPageService {

  productsList: Product[] = [];
  carouselProducts: Product[] = [];

  constructor(private httpClient: HttpClient, private carouselService:ProductCarouselService,
    private productsService:ProductService) { }

  urlBase = 'https://changuito-libre.herokuapp.com';

  getProducts(){
    return this.httpClient.get(this.urlBase);
  }

  getProductsCarousel(){
    return this.httpClient.get(this.urlBase);
  }

  setProducts(products: Product[]){
    this.productsList = products;
  }


}
