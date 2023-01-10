import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DataService } from '../data.service';
import { HttpService } from '../http.service';
import { Cluster, MenuGestore, Segnalazione, Segnalazione2 } from '../Export';

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
      this.caricato=true;//Da usare per il placeholder
    })
  }

  onConvalidaSegnalazione(segnalazione:Segnalazione2){
    switch(segnalazione.id_Stato.toString()){
      case '1':{
        segnalazione.id_Stato='2';
        break;
      }
      case '2':{
        segnalazione.id_Stato="3";
        break;
      }
      case '3':{
        segnalazione.id_Stato="2"
        break;
      }
    }
  }

  onConfermaAll(cluster:MenuGestore){
    for(let segnalazione of cluster.segnalazioni){
      segnalazione.id_Stato='2';
    }
  }

  onWarnAll(cluster:MenuGestore){
    for(let segnalazione of cluster.segnalazioni){
      segnalazione.id_Stato='3';
    }
  }

  //Il cluster che è evidenziato in quel momento è il "cluster selezionato"
  //OPPURE
  //Il cluster viene bindato da un evento(ci sono più cluster evidenziati)

  onConfermaCluster(cluster:MenuGestore){//Conferma l'operazione
    console.log(cluster)
  }
}
