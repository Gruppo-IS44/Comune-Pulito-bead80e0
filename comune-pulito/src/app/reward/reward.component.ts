import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reward',
  templateUrl: './reward.component.html',
  styleUrls: ['./reward.component.css']
})
export class RewardComponent implements OnInit{
  constructor(private dataService:DataService, private router:Router){}
  
  ngOnInit(): void {
    if(this.dataService.id_utente==null || this.dataService.isGestore==true){
      this.router.navigate(['login']);
    }
  }
}
