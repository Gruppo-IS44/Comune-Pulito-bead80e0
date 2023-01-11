import { Component, OnInit } from '@angular/core';
import Map from 'ol/Map';
import View from 'ol/View';
import Tile from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import Attribution from 'ol/source/Source';
import { defaults } from 'ol/control/defaults'
import { fromLonLat } from 'ol/proj';
import Vector from 'ol/source/Vector';
import VectorLayer  from 'ol/layer/Vector';
import GeoJSON from 'ol/format/GeoJSON';
import Style from 'ol/style/Style';
import Icon from 'ol/style/Icon';
import { Router } from '@angular/router';
import { Point } from 'ol/geom';
import { DataService } from '../data.service';
import { Feature } from '../Export';


@Component({
  selector: 'mappa',
  templateUrl: './mappa.component.html',
  styleUrls: ['./mappa.component.css'],
})
export class MappaComponent implements OnInit {
  constructor(private router:Router, private dataService:DataService){}
  caricato:boolean=false;
  isGestore?:boolean=this.dataService.isGestore;
  nome?:string=this.dataService.nome;
  cognome?:string=this.dataService.cognome;
  loggato:boolean=false;
  featureSelezionata!:Feature;
  aperto:boolean=false;
  foto!:boolean;
  desc!:boolean;

  ngOnInit(): void {
    if(this.dataService.id_utente!=null){
      this.loggato=true;
    }
      const attribution = new Attribution({       
      });      

      const map = new Map({
        layers: [
          new Tile({
            source: new OSM({
            })
          })
        ],
        controls: defaults({attribution: false}),
        target: 'map',
        view: new View({
          constrainResolution: true,
          center: fromLonLat(this.getLocation().getCoordinates()), // starting position [lng, lat]
          zoom: 5 // starting zoom
        })
      });

      const VectorSource=new Vector({
        url:'http://localhost:8080/geojson',
        format:new GeoJSON(),
      })
      const AirportLayer = new VectorLayer({
        source:VectorSource,
        style:new Style({
          image: new Icon({
              src: 'assets/delete.png',
              size: [768, 768],
              scale: 0.03
          })
        }) 
      })
      navigator.geolocation.getCurrentPosition((position)=>{
        map.setView(new View({
          constrainResolution:true,
          center: fromLonLat([position.coords.longitude, position.coords.latitude]),
          zoom:15
        }))
        this.caricato=true;
      })
      map.addLayer(AirportLayer);
      const showInfo = (event:any) => {
        const features = map.getFeaturesAtPixel(event.pixel);
        if (features.length == 0 ) {
          return;
        }
        const properties = features[0].getProperties();
        /*if(info){
          info.innerText = 'cazzi'//JSON.stringify(properties, null, 2);
          info.style.opacity = '1';
        }
        this.cazzi=info;
        console.log(this.cazzi)*/
        this.featureSelezionata={descrizione:properties['descrizione'], foto:properties['foto']};
        if(this.featureSelezionata.foto=="null"){
          this.foto=false;
        }else{
          this.foto=true;
        }
        if(this.featureSelezionata.descrizione=="null"){
          this.desc=false;
        }else{
          this.desc=true;
        }
        this.aperto=true;
      }
      map.on('click', showInfo);
  }

  clickSegnalazioni(){
    this.router.navigate(["/segnalazione"])
  }

  clickReward(){
    this.router.navigate(["/reward"])
  }

  clickGestione(){
    this.router.navigate(["/gestore"])
  }

  chiudi(){
    this.aperto=false;
  }

  clickLogout(){
    this.dataService.nome=undefined;
    this.dataService.cognome=undefined;
    this.dataService.email=undefined;
    this.dataService.password=undefined;
    this.dataService.isGestore=undefined;
    this.dataService.id_utente=undefined;
    this.router.navigate(['/login']);
  }

  getLocation():Point{
    navigator.geolocation.getCurrentPosition((position)=>{
      const longitude = position.coords.longitude;
        const latitude = position.coords.latitude;
        return new Point([longitude, latitude]);
    })
    return new Point([10,10])
  }
}
