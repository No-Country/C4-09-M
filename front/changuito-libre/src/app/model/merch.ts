import { UserDto } from '../dtos/userDto';
export class Merch{

  constructor(public idMerch:number, public name:string, public lastname:string,
    public description:string, public cuit:string, public street:string, public streetNumber:string,
    public update:string, public creation:string, public user:UserDto){}

}
