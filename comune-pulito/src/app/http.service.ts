import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { Login, Signup, SignupResponse, Token, Utente } from './Export';
import { environment } from 'src/environments/environment.prod';
import { __param } from 'tslib';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  
  constructor(private http:HttpClient) { }

  login(userLogin:Login):Observable<Token>{
    const body={"email":userLogin.email,"password":userLogin.password,"isGestore":userLogin.isGestore};
    return this.http.post<Token>(environment.baseURL+"/login", body);
  }

  addUser(utente:Utente):Observable<SignupResponse>{
    const body={"email":utente.email,"password":utente.password,"nome":utente.nome,"cognome":utente.cognome};
    console.log(body);
    return this.http.post<SignupResponse>(environment.baseURL+"/signup", body);
  }
}
