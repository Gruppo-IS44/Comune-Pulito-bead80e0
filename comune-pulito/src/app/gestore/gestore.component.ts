import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-gestore',
  templateUrl: './gestore.component.html',
  styleUrls: ['./gestore.component.css']
})
export class GestoreComponent {


  constructor(private router:RouterModule, private dataService:DataService){}
  
  ngOnInit():void {
    //Comando che richiama la query in backend per recuperare tutti i cluster, con le relative segnalazioni 
    //OPPURE 
    //recupera tutti i cluster(allocazione delle segnalazioni fatta successivamente)
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
