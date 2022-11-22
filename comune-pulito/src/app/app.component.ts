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
  login!:Login;
  signup!:Signup;
  title!:string;

  onLogin(data:any){//invocato nel momento in cui si richiede il Login con le credenziali inserite all'interno del form
    
  }

  onSignup(data:any){//invocato nel momento in cui si richiede il Signup con le credenziali inserite all'interno del form
    
  }
}
