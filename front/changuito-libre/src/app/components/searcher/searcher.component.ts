import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductDataService } from 'src/app/product-data.service';

@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.css']
})
export class SearcherComponent implements OnInit {

  searchText: any;

  products : Product[] = [];

  constructor(private productsDataService: ProductDataService) { }

  ngOnInit(): void {
    this.productsDataService._products.subscribe( products => this.products = products);

  }

}
