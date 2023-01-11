import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  id_utente:string="55";
  email!:string;
  password!:string;
  isGestore!:boolean;
  nome!:string;
  cognome!:string;
  
  constructor() { }
}
