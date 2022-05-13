import { Producto } from "./producto";


export class ApiResp{
    site_id:String;
    query:String;
    results:Producto[];
}