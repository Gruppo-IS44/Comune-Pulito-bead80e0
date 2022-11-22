import { Component,Input } from '@angular/core';
import {Tipo} from "./Tipo"

@Component({
  selector: 'switch',
  template: '<div class="uppercase"><button (click)="cambio()">Passa a {{tipo.tipo}}</button></div>',
  styles: [`button{
    border-radius:15px;
    border-width:1px;
    background-color:lightblue;
    margin-bottom:10px;
  }
  button:hover{
    box-shadow: 0 0 0 2px rgb(0 0 0 / 20%);
    transition: all 200ms ease-out;
  }`]
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
