//import { Cart } from './cart';
//import { Content } from './content';
export interface Product {

  id: number,
  brand: string,
  name: string,
  description: string,
  //  public contentDto:string,
  idImage: number,
  wholesaler_price: number,
  retail_price: number,
  status: string,
  categoryDto: number,
  stock: number,
  deleted: boolean,
  quantity: number,
  // public cart: Cart) {

  // }

}
