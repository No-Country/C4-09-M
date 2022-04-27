import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductCartService } from 'src/app/product-cart.service';
import { ProductDataService } from 'src/app/product-data.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products : Product[] = [];

  constructor(private productsDataService: ProductDataService, private productsCartService: ProductCartService,  public productService: ProductService) { }

  ngOnInit(): void {
  //  this.productsDataService._products.subscribe( products => this.products = products);
    this.productService.getProducts().subscribe(
      ( data: any )=>{
        this.products = data;
      }
    );
  
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
