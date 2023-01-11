import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  id_utente:string="6";
  email:string='f.basato@hotmail.com';
  password:string='Francone76@';
  isGestore!:boolean;
  nome!:string;
  cognome!:string;
  
  constructor() { }
}
