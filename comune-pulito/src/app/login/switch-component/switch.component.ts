import { Component,Input } from '@angular/core';
import {Tipo} from "../../Export"

@Component({
  selector: 'switch',
  templateUrl: './switch.component.html',
  styleUrls: [`./switch.component.css`]
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
