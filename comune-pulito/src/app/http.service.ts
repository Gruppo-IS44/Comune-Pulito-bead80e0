import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { Login, Signup, Utente } from './Export';
import { environment } from 'src/environments/environment.prod';
import { __param } from 'tslib';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  
  constructor(private http:HttpClient) { }

  login(userLogin:Login):Observable<Login>{
    let queryParams={"email":userLogin.email,"password":userLogin.password,"isGestore":userLogin.isGestore};
    return this.http.get<Login>(environment.baseURL+"/login",{params:queryParams})
  }

  addUser(utente:Utente):Observable<any>{
    const body = utente;
    console.log(body);
    return this.http.post(environment.baseURL + "login", body);
  }
}
