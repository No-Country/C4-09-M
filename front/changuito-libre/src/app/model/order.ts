export class Order{

  constructor(public idOrder:number, public cartId:number, public total:number,
    public idPayment:number, public update:string, public creation:string){

  }

}
