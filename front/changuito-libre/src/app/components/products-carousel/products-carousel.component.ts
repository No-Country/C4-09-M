import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductCartService } from 'src/app/product-cart.service';
import { ProductDataService } from 'src/app/product-data.service';


@Component({
  selector: 'app-products-carousel',
  templateUrl: './products-carousel.component.html',
  styleUrls: ['./products-carousel.component.css']
})
export class ProductsCarouselComponent implements OnInit {

  products : Product[] = [];

  constructor(private productsDataService: ProductDataService, private productsCartService: ProductCartService) { }

  ngOnInit(): void {
    this.productsDataService._products.subscribe( products => this.products = products);

  }

  //upQuantity(product : Product): void{
    //this.productsCartService.addToCart(product);
  //}

}
