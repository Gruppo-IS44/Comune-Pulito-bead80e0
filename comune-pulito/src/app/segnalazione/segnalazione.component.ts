import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Point from 'ol/geom/Point';
import { DataService } from '../data.service';
import { buffer } from 'ol/size';
import { HttpService } from '../http.service';
import { Segnalazione } from '../Export';
import { Router } from '@angular/router';

@Component({
  selector: 'app-segnalazione',
  templateUrl: './segnalazione.component.html',
  styleUrls: ['./segnalazione.component.css']
})
export class SegnalazioneComponent {
  posizione!:number[];
  segnalazioneForm:FormGroup=this.formBuilder.group({
    tipoRifiuto:['piccolo',Validators.required],
    descrizione:['',],
    immagine:['',],
    immagine2:['',],
    latitudine:[],
    longitudine:[]
  })
  imageSrc!:string;
  success:boolean=false;

  constructor(private http:HttpService, private formBuilder:FormBuilder, private dataService:DataService, private router:Router){}

  ngOnInit(){
    this.getLocation();
    if(this.dataService.id_utente==null || this.dataService.isGestore==true){
      this.router.navigate(['login']);
    }
  }
  
  getLocation(): void{
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position)=>{
          const longitude = position.coords.longitude;
          const latitude = position.coords.latitude;
          this.posizione= [longitude, latitude];
        });
    } else {
       console.error("No support for geolocation")
    }
  }

  onFileChange(event:any){
    const reader= new FileReader();
    if(event.target.files && event.target.files.length){
      const [file] = event.target.files;
      reader.readAsDataURL(file);
      reader.onload=()=>{
        this.imageSrc=reader.result as string;
        this.segnalazioneForm.patchValue({immagine2:reader.result});
      };
    }
  }

  onSubmit(){
    this.segnalazioneForm.patchValue({latitudine:this.posizione[1],longitudine:this.posizione[0]})
    if(this.dataService.id_utente){
      const segnalazione:Segnalazione={"foto":this.segnalazioneForm.value.immagine2, "descrizione":this.segnalazioneForm.value.descrizione, "tipo_rifiuto":1, "latitudine":this.posizione[1], "longitudine":this.posizione[0],"utente":this.dataService.id_utente.toString()}
      this.http.segnala(segnalazione).subscribe(data=>{
        this.success=true;
        setTimeout(() => {
          this.router.navigate(["/mappa"]);
        }, 3000);
      })
    }
  }
}
