import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  id_utente!:string;
  email!:string;
  password!:string;
  
  constructor() { }
}
