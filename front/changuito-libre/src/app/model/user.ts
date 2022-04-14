import { UserDto } from "../Dtos/userDto";

export class User{

  constructor(public idUser:number, public firstname:string, public lastname:string,
    public email:string, public dni:string, public birthday:string,
    public country:string, public created:string, public update:string, public user:UserDto){}

}
