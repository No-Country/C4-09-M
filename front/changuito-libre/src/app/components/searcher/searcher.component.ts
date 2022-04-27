import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductDataService } from 'src/app/product-data.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.css']
})
export class SearcherComponent implements OnInit {

  searchText: any;

  products : Product[] = [];

  constructor(private productsDataService: ProductDataService,  public productService: ProductService) { }

  ngOnInit(): void {
   // this.productsDataService._products.subscribe( products => this.products = products);
   this.productService.getProducts().subscribe(
    ( data: any )=>{
      this.products = data;
    }
  );
  }

}
