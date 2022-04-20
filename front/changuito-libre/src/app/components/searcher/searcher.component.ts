import { Component, OnInit } from '@angular/core';
import { ProductDataService } from 'src/app/product-data.service';
import { Product } from './product';

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
    this.productsDataService.products.subscribe( products => this.products = products);

  }

}
