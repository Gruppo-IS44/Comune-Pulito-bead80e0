import { Component } from '@angular/core';
import {Tipo} from "./Tipo"
import {Login} from "./Login"
import { Signup } from './Signup';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  tipo:Tipo={tipo:"Sign Up",signup:true};
  login:Login={username:"",password:"",isGestore:false};
  signup:Signup={email:"",username:"",password:"",nome:"",cognome:""};
  title!:string;

  onLogin(data:any){//invocato nel momento in cui si richiede il Login con le credenziali inserite all'interno del form
    this.setLogin(data);
    //TODO implementare il passaggio al backend
  }

  onSignup(data:any){//invocato nel momento in cui si richiede il Signup con le credenziali inserite all'interno del form
    this.setSignup(data);
    //TODO implementare il passaggio al backend
  }
  
  setLogin(temp:any) {//imposta i parametri di "login" uguali a quelli di "temp"
    this.login={username:temp.username,password:temp.password,isGestore:temp.isGestore};
  }

  setSignup(temp:any){//imposta i parametri di "signup" uguali a quelli di "temp"
    this.signup={email:temp.email,username:temp.username,password:temp.password,nome:temp.nome,cognome:temp.cognome};
  }
}