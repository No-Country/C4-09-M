import { Component, OnInit } from '@angular/core';
import { ProductCartService } from 'src/app/product-cart.service';
import { Product } from '../product-list/product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {


  products : Product[] = [];
  constructor(private productsCartService: ProductCartService) { }

  ngOnInit(): void {
    this.productsCartService.products.subscribe(data => this.products = data);
  
    
  }

  total(){
    let sum=0;
    this.products.forEach(product => {
      sum += product.quantity * product.precio});
      return sum;
  
  }
}


