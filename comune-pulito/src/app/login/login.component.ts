import { HttpClient } from '@angular/common/http';
import { Component, Injectable } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, Observable } from 'rxjs';
import {Tipo,Login,Signup} from '../Export';
import { HttpService } from '../http.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: [ 'login.component.css' ]
})

export class LoginComponent  {
  show:boolean=false
  errore:boolean=false;
  tipo:Tipo={tipo:"Sign Up",signup:true};
  signup:Signup={email:"",username:"",password:"",nome:"",cognome:""};
  signupForm:FormGroup=this.formBuilder.group({
    email:['',[Validators.email,Validators.required]],
    password:['',Validators.required],
    cpassword:['',Validators.required],
    nome:['',Validators.required],
    cognome:['',Validators.required]
  });
  title!:string;
  loginForm:FormGroup=this.formBuilder.group({
    email:['',[Validators.email, Validators.required]],
    password:['',Validators.required],
    isGestore:[false, Validators.required]
  });


  constructor(private formBuilder:FormBuilder,private httpService:HttpService, private router:Router){}

  toggleEye() {
    this.show=!this.show;
  }

  onLogin(){//invocato nel momento in cui si richiede il login
    this.httpService.login(this.loginForm.value).subscribe(data=>{
      console.log(data)
      this.router.navigate(["/map"]);
    },
    error =>{
      console.log("Errore nel login!");
      console.log(error);
      this.errore=true;
    });
    //TODO implementare autenticazione tramite cookie session based
  }
  
  /*onLogin(data:any){//invocato nel momento in cui si richiede il Login con le credenziali inserite all'interno del form
    this.setLogin(data);
    console.log(this.login);
    //TODO implementare il passaggio al backend
    this.httpService.login(this.login).subscribe(data => {
      console.log(data)
      this.login=data;});
    console.log(this.login);
  }*/

  onSignup(){//invocato nel momento in cui si richiede il Signup con le credenziali inserite all'interno del form
    this.httpService.addUser(this.signupForm.value).subscribe(data=>{
      console.log(data);
      this.router.navigate(["/map"]);
    },
    error=>{
      console.log(error)
    });
  }

  /*onSignup(data:any){//invocato nel momento in cui si richiede il Signup con le credenziali inserite all'interno del form
    this.setSignup(data);
    //TODO implementare il passaggio al backend
    this.httpService.addUser(this.signup);
  }*/

  setSignup(temp:any){//imposta i parametri di "signup" uguali a quelli di "temp" DEPRECATED
    this.signup={email:temp.email,username:temp.username,password:temp.password,nome:temp.nome,cognome:temp.cognome};
  }
}