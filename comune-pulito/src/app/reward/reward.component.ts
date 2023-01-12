import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-reward',
  templateUrl: './reward.component.html',
  styleUrls: ['./reward.component.css']
})
export class RewardComponent implements OnInit{
  card1:number=0;
  card2:number=0;
  card3:number=0;
  selezionato=1;
  carrello:Array<number>=[0,0,0];
  totale:number=0;
  crediti:number=0;

  constructor(private dataService:DataService, private router:Router, private http:HttpService){}
  
  ngOnInit(): void {
    /*if(this.dataService.id_utente==null || this.dataService.isGestore==true){
      this.router.navigate(['login']);
    }*/
    if(this.dataService.id_utente)
    this.http.ottieniBilancio(this.dataService.id_utente).subscribe(data=>{
      this.crediti=data;
    })
  }
  
  home(){
    this.router.navigate(['mappa']);
  }

  compra(){
    this.carrello=[this.card1,this.card2,this.card3];
    this.totale=this.carrello[0]*50+this.carrello[1]*1000+this.carrello[2]*100
  }
}
