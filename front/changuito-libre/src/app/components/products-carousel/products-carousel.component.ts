import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductCartService } from 'src/app/product-cart.service';
import { ProductDataService } from 'src/app/product-data.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products-carousel',
  templateUrl: './products-carousel.component.html',
  styleUrls: ['./products-carousel.component.css']
})
export class ProductsCarouselComponent implements OnInit {

  products : Product[] = [];

  constructor(private productsDataService: ProductDataService, private productsCartService: ProductCartService, public productService: ProductService) { }

  ngOnInit(): void {
   // this.productsDataService.products.subscribe(products => this.products = products);
    this.productService.getProducts().subscribe(
      ( data: any )=>{
        this.products = data;
      }
    );
    }

  upQuantity(product : Product): void{
    this.productsCartService.addToCart(product);
 }

}
