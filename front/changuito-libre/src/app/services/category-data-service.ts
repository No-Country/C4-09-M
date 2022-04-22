import { Category } from './../model/category';
import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryDataService {

  categories: Category[] = [];

  constructor(private http: HttpClient){
  }

  urlBase = 'https://changuito-libre.herokuapp.com/category/';

  getCategories(){
    return this.http.get(this.urlBase+'all');
  }

}
