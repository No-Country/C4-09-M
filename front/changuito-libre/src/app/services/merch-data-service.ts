import { Merch } from './../model/merch';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';



@Injectable({
  providedIn: 'root'
})
export class MerchDataService {

  merchs: Merch[]=[];

  constructor(private http: HttpClient) { }

  urlBase!: 'https://changuito-libre.herokuapp.com';


  getMerchs(){
    return this.http.get(this.urlBase+'/merchandisers');
  }

  addMerch(merch: Merch){
    return this.http.post(this.urlBase + '/merchandisers', merch);
  }

  updateMerch(idMerch: number, merch: Merch){
    let url: string;
    url = this.urlBase + '/merchandisers/' + idMerch;
    this.http.put(url, merch)
      .subscribe(
        (response) => {
          console.log('resultado modificar merch: ' + response);
        },
        (error) => console.log('Error en modificar merch:' + error)
      );
  }

  deleteMerch(idMerch: number){
    let url: string;
    url = this.urlBase + '/merchandiser/' + idMerch;
    this.http.delete(url)
    .subscribe(
      (response) => {
        console.log('resultado eliminar merch: ' + response);
      },
      (error) => console.log('Error en eliminar merch:' + error)
    );
  }



}
