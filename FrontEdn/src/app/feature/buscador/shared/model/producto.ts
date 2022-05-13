import { Seller } from "./seller";
import { Shipping } from "./Shipping";

export class Producto{
    id:String;
    title:String;
    seller:Seller;
    price:number;
    sold_quantity:number;
    condition:String;
    permalink:String;
    thumbnail:String;
    shipping:Shipping;
    category_id:String;
}