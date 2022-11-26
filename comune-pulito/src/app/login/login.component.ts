import { HttpClient } from '@angular/common/http';
import { Component, Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import {Tipo,Login,Signup} from '../Export';
import { HttpService } from '../http.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: [ 'login.component.css' ]
})

export class LoginComponent  {
  tipo:Tipo={tipo:"Sign Up",signup:true};
  login:Login={email:"",password:"",isGestore:false};
  signup:Signup={email:"",username:"",password:"",nome:"",cognome:""};
  title!:string;
  login2!:Login;

  constructor(private httpService:HttpService){}

  onLogin(data:any){//invocato nel momento in cui si richiede il Login con le credenziali inserite all'interno del form
    this.setLogin(data);
    console.log(this.login);
    //TODO implementare il passaggio al backend
    this.httpService.login(this.login).subscribe(data => {
      console.log(data)
      this.login=data;});
    console.log(this.login);
  }

  onSignup(data:any){//invocato nel momento in cui si richiede il Signup con le credenziali inserite all'interno del form
    this.setSignup(data);
    //TODO implementare il passaggio al backend
    this.httpService.addUser(this.signup);
  }
  
  setLogin(temp:any) {//imposta i parametri di "login" uguali a quelli di "temp"
    if(temp.isGestore==="true"){
      this.login={email:temp.username,password:temp.password,isGestore:true};
      return;
    }
    this.login={email:temp.username,password:temp.password,isGestore:false};    
  }

  setSignup(temp:any){//imposta i parametri di "signup" uguali a quelli di "temp"
    this.signup={email:temp.email,username:temp.username,password:temp.password,nome:temp.nome,cognome:temp.cognome};
  }
}