import { Component } from '@angular/core';
import {Tipo} from "./Tipo"
import {Login} from "./Login"

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  name = 'Angular';
  tipo:Tipo={tipo:"Sign Up",signup:true};
  login!:Login;

  onLogin(data){//invocato nel momento in cui si richiede il Login con le credenziali inserite all'interno del form
    
  }

  onSignup(data){//invocato nel momento in cui si richiede il Signup con le credenziali inserite all'interno del form
    
  }
}
