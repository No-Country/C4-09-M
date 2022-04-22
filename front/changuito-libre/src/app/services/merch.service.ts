import { Merch } from './../model/merch';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MerchDataService } from './merch-data-service';



@Injectable({
  providedIn: 'root'
})
export class MerchService {

  merchs: Merch[]=[];

  constructor(private http: HttpClient, private merchDataService: MerchDataService) { }


  setMerchs(merchs: Merch[]){
      this.merchs = merchs;
  }

  getMerchs(){
    return this.merchDataService.getMerchs();
  }

  addMerch(merch: Merch){
    return this.merchDataService.addMerch(merch)
    .subscribe(
      (merch: any)=>{
        this.merchs.push(merch);
      }
     );
  }

  updateMerch(idMerch: number, merch: Merch){
       // se actualiza el objeto persona del arreglo
    const merchModificadoLocal = this.merchs.find(merch => merch.idMerch == idMerch)!;
    merchModificadoLocal.idMerch = merch.idMerch;
    merchModificadoLocal.name = merch.name;
    merchModificadoLocal.cuit = merch.cuit;
    merchModificadoLocal.description = merch.description;
    merchModificadoLocal.email = merch.email;
    merchModificadoLocal.street = merch.street;
    merchModificadoLocal.streetNumber = merch.streetNumber;
    merchModificadoLocal.user.username = merch.user.username;
    merchModificadoLocal.user.password =merch.user.password;
    // guardar la persona en la base de datos
    this.merchDataService.updateMerch(idMerch, merch);
  }

  deleteMerch(idMerch: number){
    console.log('eliminar merch con id:' + Merch);
    const index = this.merchs.findIndex( merch => merch.idMerch == idMerch);
    this.merchs.splice(index,1);
    this.merchDataService.deleteMerch(idMerch);
  }



}
