import { CategoryDataService } from './category-data-service';
import { Injectable } from '@angular/core';
import { Category } from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  categories: Category[]=[];

  constructor(private categoryDataService: CategoryDataService) { }

  setCategories(categories: Category[]){
    this.categories = categories;
}

getCategories(){
  return this.categoryDataService.getCategories();
}
}
