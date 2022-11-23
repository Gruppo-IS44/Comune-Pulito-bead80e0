import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login, Signup, Utente } from './Export';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  baseURL:string ="http://localhost:8080/"
  
  constructor(private http:HttpClient) { }

  addUser(utente:Utente):Observable<any>{
    const body = JSON.stringify(utente);
    console.log(body);
    return this.http.post(this.baseURL + "login", body);
  }
}
