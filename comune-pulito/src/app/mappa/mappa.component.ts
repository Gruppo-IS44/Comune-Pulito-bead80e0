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


@Component({
  selector: 'mappa',
  templateUrl: './mappa.component.html',
  styleUrls: ['./mappa.component.css'],
})
export class MappaComponent implements OnInit {
  constructor(private router:Router, private dataService:DataService){}
  caricato:boolean=false;
  isGestore:boolean=this.dataService.isGestore;
  nome:string=this.dataService.nome;
  cognome:string=this.dataService.cognome;

  ngOnInit(): void {
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
              src: 'https://docs.maptiler.com/openlayers/geojson-points/icon-plane-512.png',
              size: [512, 512],
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
      map.on('singleclick', showInfo);

      function showInfo(event:any) {
        const info=document.getElementById('info');
        const features = map.getFeaturesAtPixel(event.pixel);
        if (features.length == 0 && info) {
          info.innerText = '';
          info.style.opacity = '0';
          return;
        }
        const properties = features[0].getProperties();
        if(info){
          info.innerText = JSON.stringify(properties, null, 2);
          info.style.opacity = '1';
        }
        console.log(info)
      }  
  }

  clickSegnalazioni(){
    console.log("stai andando alle segnalazioni")
    this.router.navigate(["/segnalazione"])
  }

  clickReward(){
    console.log("stai andando alle reward")
    this.router.navigate(["/reward"])
  }

  clickGestione(){
    this.router.navigate(["/gestore"])
  }

  clickLogout(){
    console.log("logout o7")
  }

  getLocation():Point{
    navigator.geolocation.getCurrentPosition((position)=>{
      const longitude = position.coords.longitude;
        const latitude = position.coords.latitude;
        console.log(longitude);
        console.log(latitude);
        return new Point([longitude, latitude]);
    })
    return new Point([10,10])
  }
}
