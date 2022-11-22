import { Component,Input } from '@angular/core';
import {Tipo} from "./Tipo"

@Component({
  selector: 'switch',
  template: '<button (click)="cambio()">Passa a {{tipo.tipo}}</button>',
  styles: [`h1 { font-family: Lato; }`]
})
export class SwitchComponent{
  @Input()
  tipo!:Tipo;

  cambio():void{
    if(this.tipo.signup){
      this.tipo.tipo="Login";
    }else{
      this.tipo.tipo="Sign Up";
    }
    this.tipo.signup = !this.tipo.signup;
  }
}
