import { Component, OnInit } from '@angular/core';
import { ProductCartService } from 'src/app/product-cart.service';
import { ProductDataService } from 'src/app/product-data.service';
import { Product } from '../products-carousel/product'

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products : Product[] = [];


  constructor(private productsDataService: ProductDataService, private productsCartService: ProductCartService) { }

  ngOnInit(): void {
    this.productsDataService.products.subscribe( products => this.products = products);
  }

  upQuantity(product : Product): void{
    if(product.stock > product.quantity) {
      product.quantity ++;
      this.productsCartService.addToCart(product);
    }
  }

  downQuantity(product : Product): void{
    if(product.quantity > 0){
      product.quantity --;
      this.productsCartService.addToCart(product);
    }
  }

  verifyProductQuantity(product : Product): void {
    if(product.stock < product.quantity) {
      product.quantity = product.stock;
    }
  if (product.quantity <0){
    product.quantity = 0;
  }
  }


}
