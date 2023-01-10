import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DataService } from '../data.service';
import { HttpService } from '../http.service';
import { MenuGestore } from '../Export';

@Component({
  selector: 'app-gestore',
  templateUrl: './gestore.component.html',
  styleUrls: ['./gestore.component.css']
})
export class GestoreComponent implements OnInit {
  nome:string=this.dataService.nome;
  cognome:string=this.dataService.cognome;
  data!:Array<MenuGestore>;
  caricato:boolean=false;

  constructor(private router:RouterModule, private dataService:DataService, private http:HttpService){}
  
  ngOnInit():void {
    this.http.ottieniCluster(this.dataService.id_utente).subscribe(data=>{
      console.log(data)
      this.data=data;
      console.log(this.data)
      this.caricato=true;
    })
  }

  //Il cluster che è evidenziato in quel momento è il "cluster selezionato"
  //OPPURE
  //Il cluster viene bindato da un evento(ci sono più cluster evidenziati)

  confermaCluster(){
    //Approva il cluster selezionato
  }

  segnalaCluster(){
    //Respinge il cluster selezionato
  }

}
