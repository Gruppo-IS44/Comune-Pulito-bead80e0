import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Point from 'ol/geom/Point';

@Component({
  selector: 'app-segnalazione',
  templateUrl: './segnalazione.component.html',
  styleUrls: ['./segnalazione.component.css']
})
export class SegnalazioneComponent {
  posizione!:Point;
  segnalazioneForm:FormGroup=this.formBuilder.group({
    tipoRifiuto:['piccolo',Validators.required],
    descrizione:['',],
    immagine:[null,Validators.required]
  })

  constructor(private formBuilder:FormBuilder){}

  ngOnInit(){
    this.getLocation();
  }
  
  getLocation(): void{
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position)=>{
          const longitude = position.coords.longitude;
          const latitude = position.coords.latitude;
          console.log(longitude);
          console.log(latitude);
          this.posizione= new Point([longitude, latitude]);
          console.log(this.posizione)
        });
    } else {
       console.log("No support for geolocation")
    }
  }

  onSubmit(){
    console.log(this.segnalazioneForm);
  }
}
