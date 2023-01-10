import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Point from 'ol/geom/Point';
import { DataService } from '../data.service';
import { buffer } from 'ol/size';
import { HttpService } from '../http.service';
import { Segnalazione } from '../Export';

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

  constructor(private http:HttpService, private formBuilder:FormBuilder, private dataService:DataService){}

  ngOnInit(){
    this.getLocation();
    console.log(this.dataService)//Dati utente che sta creando la segnalazione.
  }
  
  getLocation(): void{
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position)=>{
          const longitude = position.coords.longitude;
          const latitude = position.coords.latitude;
          console.log(longitude);
          console.log(latitude);
          this.posizione= [longitude, latitude];
          console.log(this.posizione)
        });
    } else {
       console.log("No support for geolocation")
    }
  }

  onFileChange(event:any){
    const reader= new FileReader();
    console.log(event)
    if(event.target.files && event.target.files.length){
      const [file] = event.target.files;
      console.log(file);
      reader.readAsDataURL(file);
      console.log(reader.result)
      reader.onload=()=>{
        console.log(reader.result)
        this.imageSrc=reader.result as string;
        this.segnalazioneForm.patchValue({immagine2:reader.result});
      };
    }
  }

  onSubmit(){
    this.segnalazioneForm.patchValue({latitudine:this.posizione[1],longitudine:this.posizione[0]})
    console.log(this.segnalazioneForm.value);
    const segnalazione:Segnalazione={"foto":this.segnalazioneForm.value.immagine2, "descrizione":this.segnalazioneForm.value.descrizione, "tipo_rifiuto":1, "latitudine":this.posizione[1], "longitudine":this.posizione[0],"utente":this.dataService.id_utente.toString()}
    console.log(segnalazione)
    this.http.segnala(segnalazione).subscribe(data=>{
      console.log(this.segnalazioneForm);
    })
  }
}
