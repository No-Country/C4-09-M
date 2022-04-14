import { Byte } from "@angular/compiler/src/util";

export class Image{

  constructor(public idImage:number, public name:string, public mine:string,
    public content: Byte){}

}
