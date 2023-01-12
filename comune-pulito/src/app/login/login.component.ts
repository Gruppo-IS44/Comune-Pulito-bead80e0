import { HttpClient } from '@angular/common/http';
import { Component, Injectable} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, Observable } from 'rxjs';
import {Tipo,Login,Signup} from '../Export';
import { HttpService } from '../http.service';
import { DataService } from '../data.service';
import { sha256 } from 'js-sha256';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: [ 'login.component.css' ]
})

export class LoginComponent{
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
  erroreSignup:boolean=false;

  constructor(private formBuilder:FormBuilder,private httpService:HttpService, private router:Router, private dataService:DataService){}
  
  toggleEye() {
    this.show=!this.show;
  }

  home(){
    this.router.navigate(['mappa']);
  }

  onLogin(){//invocato nel momento in cui si richiede il login    
    this.httpService.login(this.loginForm.value).subscribe(data=>{
      this.dataService.id_utente=data.token;
      this.dataService.email=this.loginForm.value.email;
      this.dataService.isGestore=this.loginForm.value.isGestore;
      this.dataService.password=sha256(this.loginForm.value.password);
      this.dataService.nome=data.nome;
      this.dataService.cognome=data.cognome;
      this.router.navigate(["/mappa"]);
    },
    error =>{
      console.error("Errore nel login!");
      console.error(error.message);
      this.errore=true;
    });
  }

  onSignup(){//invocato nel momento in cui si richiede il Signup con le credenziali inserite all'interno del form
    this.httpService.addUser(this.signupForm.value).subscribe(data=>{
      this.erroreSignup=false;
      this.dataService.email=this.signupForm.value.email;
      this.dataService.nome=this.signupForm.value.nome;
      this.dataService.cognome=this.signupForm.value.cognome;
      this.dataService.password=sha256(this.signupForm.value.password);
      this.dataService.id_utente=data.userLogin.token;
      this.router.navigate(["/mappa"]);
    },
    error=>{
      console.log(error)
      this.erroreSignup=true;
    });
  }
}