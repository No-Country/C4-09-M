import { Cart } from './cart';
import { Content } from './content';
export class Product{

  constructor(public idProduct:number,
    public brand:string,
    public name:string,
    public description:string,
    public content:Content,
    public idImage:File,
    public wholesaler_price:number,
    public retail_price:number,
    public status:string,
    public idCategory:number,
    public stock:number,
    public cart: Cart) {

  }

}
