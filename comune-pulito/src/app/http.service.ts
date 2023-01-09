import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { Login, Segnalazione, Signup, SignupResponse, Token, Utente } from './Export';
import { environment } from 'src/environments/environment.prod';
import { __param } from 'tslib';
import { sha256 } from 'js-sha256';

@Injectable({
  providedIn: 'root'
})
export class HttpService {  
  constructor(private http:HttpClient) { }

  login(userLogin:Login):Observable<Token>{
    const pass=sha256(userLogin.password);
    const body={"email":userLogin.email,"password":pass,"isGestore":userLogin.isGestore};
    return this.http.post<Token>(environment.baseURL+"/login", body)
  }

  addUser(utente:Utente):Observable<SignupResponse>{
    const pass=sha256(utente.password);
    const body={"email":utente.email,"password":pass,"nome":utente.nome,"cognome":utente.cognome};
    console.log(body);
    return this.http.post<SignupResponse>(environment.baseURL+"/signup", body);
  }

  segnala(segnalazione:Segnalazione):Observable<Object>{
    console.log(segnalazione)
    return this.http.post<Object>(environment.baseURL+"/segnalazione",segnalazione);
  }
}
